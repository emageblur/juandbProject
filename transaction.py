from BTrees.OOBTree import OOBTree
import sqlparse
from sqlparse.sql import Where, Comparison, Parenthesis, Identifier
import collections
from tableStructures import *
import re
import ast
import time
from datetime import datetime
from threading import Thread

global code
global tbldata
global headers

def processQry(parsed,statementType,tableName):
    global code
    global tbldata
    global headers

    code = 202
    tbl = []
    headers = []
    tbldata = {}
    

    if (statementType == "INSERT"):
        insertData(tableName,parsed,False)
    elif (statementType == "DELETE"):
        deleteData(tableName,parsed)
    elif (statementType == "SELECT"):
        selectData(tableName,parsed)
    else:
        code = 406

    tbl.append(tbldata)
 
    return code,tbl,headers

def uploadInsert(filePath,tableName):
    global code
    
    if tableName == 'student':
        targetDict = studentDict
    elif tableName == 'studcourse':
        targetDict = studcourseDict
    elif tableName == 'studenthistory':
        targetDict = studenthistoryDict
    elif tableName == 'course':
        targetDict = courseDict
    elif tableName == 'courseoffering':
        targetDict = courseofferingDict
    else:
        pass
    
    varTypeList = []
    keyList = []

    for key in targetDict:
        varTypeList.append(targetDict[key][1])
        keyList.append(key)

    
    file = open(filePath,"r")

    for lines in file:
        data = lines.rstrip("\n\r").replace('"','').split(',')
        valuesEntry = ''
        i = 0
        if len(data) <= len(varTypeList) and len(data) > 0:
            i = 0
            for entry in data:
                if varTypeList[i] == 'char':
                    if entry.strip() == '':
                        if keyList[i] in dateList:
                            item = '"1900-01-01"'
                        elif keyList[i] in timeList:
                            item = '"00:00"'
                        elif keyList[i] in semList:
                            item ='"1st"'
                        else:
                            item = '"null"'	
                    else:
                        item = '"'+str(entry).lower()+'"'
                else:
                    if str(entry).strip().isdigit():
                        item = str(int(entry))
                    else:
                        item = '0'
                i+=1
                
                if valuesEntry == '':
                    valuesEntry = item
                else:
                    if not str(item) =='':
                        valuesEntry = valuesEntry+','+item


            qry = 'insert into '+tableName+' values ('+valuesEntry+');'
            parsed = sqlparse.parse(qry)
            insertData(tableName,parsed[0],True)
           
        else:
            pass 

    file.close()

     
    try:
        Thread(target= saveTable, args=(tableName,)).start() 
    except:
        print("File is busy...")
        pass
    
    
    return code

def insertData(tableName,parsed,bulk):
    global code
    inputValues = []
    columnsList = []
    noColumns = False
    save = False

    studnoformat = re.compile("\d{4}-\d{5}")
    birthdayformat = re.compile("\d{4}-\d{2}-\d{2}")
    timeformat = re.compile("\d{2}:\d{2}")
    semformat = ["1st","2nd","sum"]
    haslabformat = [0,1]

    if (isinstance(parsed.tokens[4], Identifier)):
        noColumns = True
    else:
        noColumns = False
        functionSplit = str(parsed.tokens[4]).split("(")[1][:-1].split(",")
        for col in functionSplit:
            columnsList.append(col.strip())
    
    for subsubtokens in parsed.tokens[8][1] :
            subsubtokens = str(subsubtokens)
            if (subsubtokens != ",") :
                if (subsubtokens.isdigit()):
                    inputValues.append(int(subsubtokens))
                else:
                    if subsubtokens.replace('"','').strip()=='':
                        inputValues.append('null')
                    else:
                        inputValues.append(subsubtokens.replace('"','').strip())
                       
                        
    if(tableName == "student"):

        if noColumns:

            if STUDENT.has_key(inputValues[0]):
                code = 405
            else:
        
                if len(inputValues) <= len(studentDict) and not len(inputValues) < 1:
                    if len(inputValues) == 1:
                        inputValues.extend(['null','1900-01-01','null','null',0])
                    elif len(inputValues) == 2:
                        inputValues.extend(['1900-01-01','null','null',0])
                    elif len(inputValues) == 3:
                        inputValues.extend(['null','null',0])
                    elif len(inputValues) == 4:
                        inputValues.extend(['null',0])
                    elif len(inputValues) == 5:
                        inputValues.append(0)
                    
                    if studnoformat.match(inputValues[0]) and birthdayformat.match(inputValues[2]) and str(inputValues[5]).isdigit() :
                        STUDENT.update({str(inputValues[0]):[str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),str(inputValues[3]),str(inputValues[4]),inputValues[5]]})
                        code = 202
                        save = True
                    else:
                        code = 406
                else:
                    code = 404

        else:
            if len(inputValues) <= len(studentDict) and len(columnsList) == len(inputValues) and 'studno' in columnsList:

                if STUDENT.has_key(inputValues[columnsList.index('studno')]):
                    code = 405
                else:
                    
                    tempInputValues = inputValues
                    inputValues = []

                    for key in studentDict.keys() :
                        if not key in columnsList:
                            if key == 'birthday':
                                inputValues.append('1900-01-01')
                            elif key == 'unitsearned':
                                inputValues.append(0)
                            else:
                                inputValues.append('null')
                        else:
                            inputValues.append(tempInputValues[columnsList.index(key)])

                    if studnoformat.match(inputValues[0]) and birthdayformat.match(inputValues[2]) and str(inputValues[5]).isdigit() : 
                        STUDENT.update({str(inputValues[0]):[str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),str(inputValues[3]),str(inputValues[4]),inputValues[5]]})
                        code = 202
                        save = True
                    else:
                        code = 406      
            else:
                code = 404

    elif(tableName == "course"):

        if noColumns:
            
            if COURSE.has_key(inputValues[0]):
                code = 405
            else:
                if len(inputValues) <= len(courseDict) and not len(inputValues) < 1:
                    if len(inputValues) == 1:
                        inputValues.extend(['null','null',0,0,'1st'])
                    elif len(inputValues) == 2:
                        inputValues.extend(['null',0,0,'1st'])
                    elif len(inputValues) == 3:
                        inputValues.extend([0,0,'1st'])
                    elif len(inputValues) == 4:
                        inputValues.extend([0,'1st'])
                    elif len(inputValues) == 5:
                        inputValues.append('1st')
                    
                    if str(inputValues[3]).isdigit() and str(inputValues[4]).isdigit() and int(inputValues[4]) in haslabformat and inputValues[5] in semformat : 
                        COURSE.update({str(inputValues[0]):[str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),inputValues[3],inputValues[4],str(inputValues[5])]})
                        code = 202
                        save = True
                    else:
                        code = 406
                else:
                    code = 404

        else:

            if len(inputValues) <= len(courseDict) and len(columnsList) == len(inputValues) and 'cno' in columnsList:

                if COURSE.has_key(inputValues[columnsList.index('cno')]):
                    code = 405
                else:

                    tempInputValues = inputValues
                    inputValues = []

                    for key in courseDict.keys() :
                        if not key in columnsList:
                            if key == 'noofunits' or key == 'haslab':
                                inputValues.append(0)
                            elif key == 'semoffered':
                                inputValues.append('1st')
                            else:
                                inputValues.append('null')
                        else:
                            inputValues.append(tempInputValues[columnsList.index(key)])

                    if str(inputValues[3]).isdigit() and str(inputValues[4]).isdigit() and int(inputValues[4]) in haslabformat and inputValues[5] in semformat : 
                        COURSE.update({str(inputValues[0]):[str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),inputValues[3],inputValues[4],str(inputValues[5])]})
                        code = 202
                        save = True
                    else:
                        code = 406

            else:
                code = 404
        

    elif(tableName == "courseoffering"):

        if noColumns:
        
            if len(inputValues) <= len(courseofferingDict) and not len(inputValues) < 1:

                if len(inputValues) == 1:
                    inputValues.extend(['null','null','null','00:00',0])
                elif len(inputValues) == 2:
                    inputValues.extend(['null','null','00:00',0])
                elif len(inputValues) == 3:
                    inputValues.extend(['null','00:00',0])
                elif len(inputValues) == 4:
                    inputValues.extend(['00:00',0])
                elif len(inputValues) == 5:
                    inputValues.append(0)

               
                if inputValues[0] in semformat and COURSE.has_key(inputValues[2]) and timeformat.match(inputValues[4]) and str(inputValues[5]).isdigit() : 
                    COURSEOFFERING.update({ datetime.strftime(datetime.today(),'%d%m%Y%H%M%S%f') : [str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),str(inputValues[3]),str(inputValues[4]),inputValues[5]]})
                    
                    code = 202
                    save = True
                    time.sleep(0.01)

                else:
                    code = 406
            else:

                code = 404
            
            

        else:

            if len(inputValues) <= len(courseofferingDict) and len(columnsList) == len(inputValues) and 'cno' in columnsList:

                tempInputValues = inputValues
                inputValues = []

                for key in courseofferingDict.keys() :
                        if not key in columnsList:
                            if key == 'time':
                                inputValues.append('00:00')
                            elif key == 'semester':
                                inputValues.append('1st')
                            elif key == 'maxstud':
                                inputValues.append(0)
                            else:
                                inputValues.append('null')
                        else:
                            inputValues.append(tempInputValues[columnsList.index(key)])

                if inputValues[0] in semformat and COURSE.has_key(inputValues[2]) and timeformat.match(inputValues[4]) and str(inputValues[5]).isdigit() :
                    COURSEOFFERING.update({ datetime.strftime(datetime.today(),'%d%m%Y%H%M%S%f'): [str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),str(inputValues[3]),str(inputValues[4]),inputValues[5]]})
                    code = 202
                    save = True
                    time.sleep(0.01)
                else:
                    code = 406

            else:
                code = 404

    elif(tableName == "studcourse"):

        if noColumns:
   
            if len(inputValues) <= len(studcourseDict) and not len(inputValues) < 1:

                if len(inputValues) == 1:
                    inputValues.extend(['null','1st','1900-1901'])
                elif len(inputValues) == 2:
                    inputValues.extend(['1st','1900-1901'])
                elif len(inputValues) == 3:
                    inputValues.extend(['1900-1901'])
                
               
                if STUDENT.has_key(inputValues[0]) and COURSE.has_key(inputValues[1]) and inputValues[2] in semformat :
                    STUDCOURSE.update({ datetime.strftime(datetime.today(),'%d%m%Y%H%M%S%f'): [str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),str(inputValues[3])]})
                    code = 202
                    save = True
                    time.sleep(0.01)
                else:
                    code = 406
                
            else:
                code = 404

        else:

            if len(inputValues) <= len(studcourseDict) and len(columnsList) == len(inputValues) and 'cno' in columnsList and 'studno' in columnsList:

                tempInputValues = inputValues
                inputValues = []

                for key in studcourseDict.keys() :
                        if not key in columnsList:
                            if key == 'semester':
                                inputValues.append('1st')
                            else:
                                inputValues.append('null')
                        else:
                            inputValues.append(tempInputValues[columnsList.index(key)])

                if STUDENT.has_key(inputValues[0]) and COURSE.has_key(inputValues[1]) and inputValues[2] in semformat :
                    STUDCOURSE.update({ datetime.strftime(datetime.today(),'%d%m%Y%H%M%S%f'): [str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),str(inputValues[3])]})
                    code = 202
                    save = True
                    time.sleep(0.01)
                else:
                    code = 406
            else:
                code = 404

    elif(tableName == "studenthistory"):

        if noColumns:
            
            if len(inputValues) <= len(studenthistoryDict) and not len(inputValues) < 1:

                if len(inputValues) == 1:
                    inputValues.extend(['null','null','1900-01-01','1900-01-01'])
                elif len(inputValues) == 2:
                    inputValues.extend(['null','1900-01-01','1900-01-01'])
                elif len(inputValues) == 3:
                    inputValues.extend(['1900-01-01','1900-01-01'])
                elif len(inputValues) == 4:
                    inputValues.extend(['1900-01-01'])
                 
                if STUDENT.has_key(inputValues[0]) and birthdayformat.match(inputValues[3]) and birthdayformat.match(inputValues[4]):
                    STUDENTHISTORY.update({ datetime.strftime(datetime.today(),'%d%m%Y%H%M%S%f'): [str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),str(inputValues[3]),str(inputValues[4])]})
                    code = 202
                    save = True
                    time.sleep(0.01)
                else:
                    code = 406
            else:
                code = 404

        else:

            if len(inputValues) <= len(studenthistoryDict) and len(columnsList) == len(inputValues) and 'studno' in columnsList:

                tempInputValues = inputValues
                inputValues = []

                for key in studenthistoryDict.keys() :
                        if not key in columnsList:
                            if key == 'datefiled' or key == 'dateresolved':
                                inputValues.append('1900-01-01')
                            else:
                                inputValues.append('null')
                        else:
                            inputValues.append(tempInputValues[columnsList.index(key)])

                if STUDENT.has_key(inputValues[0]) and birthdayformat.match(inputValues[3]) and birthdayformat.match(inputValues[4]) :
                    STUDENTHISTORY.update({ datetime.strftime(datetime.today(),'%d%m%Y%H%M%S%f'): [str(inputValues[0]),str(inputValues[1]),str(inputValues[2]),str(inputValues[3]),str(inputValues[4])]})
                    code = 202
                    save = True
                    time.sleep(0.01)
                else:
                    code = 406

                
            else:
                code = 404

    else:
        code = 408
    
    if save and not bulk:
        try:
            Thread(target= saveTable, args=(tableName,)).start() 
        except:
            print("File is busy...")
            pass

def loadTables():

    fileList = ["STUDENT","COURSE","COURSEOFFERING","STUDCOURSE","STUDENTHISTORY"]
    suc = False

    try:

        for fileName in fileList:
            
            file = open("tables/"+fileName,"r")
            buffer = {}

            for data in file:
                buffer.update(ast.literal_eval(data))
              
            if fileName == "STUDENT":
                STUDENT.update(buffer)
            elif fileName == "COURSE":
                COURSE.update(buffer)
            elif fileName == "COURSEOFFERING":
                COURSEOFFERING.update(buffer)
            elif fileName == "STUDCOURSE":
                STUDCOURSE.update(buffer)
            elif fileName == "STUDENTHISTORY":
                STUDENTHISTORY.update(buffer)
            else:
                pass

            file.close()
        suc = True
    except:
        suc = False
    return suc

def saveTable(tableName):

    if tableName == "student":
        targetTable = STUDENT
    elif tableName == "course":
        targetTable = COURSE
    elif tableName == "studcourse":
        targetTable = STUDCOURSE
    elif tableName == "courseoffering":
        targetTable = COURSEOFFERING
    elif tableName == "studenthistory":
        targetTable = STUDENTHISTORY
    else:
        print("Table not found")
    
    targetFile = open("tables/"+tableName.upper(),"w")

    for data in targetTable.iteritems():
        targetFile.write("{'"+data[0]+"':"+str(data[1])+"}\n")

    targetFile.close()
     
def deleteData(tableName,parsed):
    global code
    code = 202

    if (isinstance(parsed.tokens[-1], Where)):

        operator = ""
        conditions = []
        popKeyList = []
       
        for case in parsed.tokens[-1]:
            
            if isinstance(case,Comparison):
                tempCon = []
                for compItem in case.tokens:

                    if isinstance(compItem,Identifier):
                        tempCon.append(re.sub('"','',compItem.value))
                    else:
                        if not compItem.value.strip() == '':
                            tempCon.append(compItem.value)
                conditions.append(tempCon)

            else:
                if str(case) == "and" :
                    if not operator == "":
                        code = 407
                    else:
                        operator = "and"
                elif str(case) == "or" :
                    if not operator == "":
                        code = 407
                    else:
                        operator = "or"
                else:
                    if not str(case) == "where" and not str(case) == ";" and not str(case).strip() == "":
                        code = 407
        if len(conditions) > 1 and operator == "":
            code = 407  

        if tableName =="student":
            targetTable = STUDENT
            colList = list(studentDict.keys())
        elif tableName == "course":
            targetTable = COURSE
            colList = list(courseDict.keys())
        elif tableName == "studcourse":
            targetTable = STUDCOURSE
            colList = list(studcourseDict.keys())
        elif tableName == "courseoffering":
            targetTable = COURSEOFFERING
            colList = list(courseofferingDict.keys())
        elif tableName == "studenthistory":
            targetTable = STUDENTHISTORY
            colList = list(studenthistoryDict.keys())
        else:
            code = 408

        if not code == 408 and not code == 407:

            for cond in conditions:
                if not cond[0] in colList:
                    code = 404
             
            if not code == 404 :

                for key,data in targetTable.iteritems():
                    results = []
                    tagged = False
                    for cond in conditions:
                        
                        try:
                            if cond[0] in integerList and cond[2].isdigit():
                                valB = int(cond[2])
                                valA = int(data[colList.index(cond[0])])
                            elif cond[0] in dateList:
                                valB = time.strptime(cond[2],"%Y-%m-%d" )
                                valA = time.strptime(data[colList.index(cond[0])],"%Y-%m-%d")
                            elif cond[0] in timeList:
                                valB = time.strptime(cond[2], "%H:%M" )
                                valA = time.strptime(data[colList.index(cond[0])], "%H:%M" )
                            else:
                                valB = cond[2]
                                valA = data[colList.index(cond[0])]
                      
                            if cond[1] == '=' :
                                if valA == valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            elif cond[1] == '<' :
                                if valA < valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            elif cond[1] == '>' :
                                if valA > valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            elif cond[1] == '<=' :
                                if valA <= valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            elif cond[1] == '>=' :
                                if valA >= valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            else:
                                code = 406
                            
                        except:
                            code = 406

                    if not operator == '' and not code == 406:
                        if operator == 'and':
                            tagged = results[0] * results[1]
                        elif operator == 'or':
                            tagged = results[0] + results[1]
                        else:
                            code = 406
                    else:
                        tagged = results[0]
                    
                    if tagged:
                        popKeyList.append(key)

                if not len(popKeyList) == 0 :
                    for popKey in popKeyList:
                        if tableName == "student" and STUDENT.has_key(popKey):
                            STUDENT.pop(popKey)
                            code = 202
                        elif tableName == "course" and COURSE.has_key(popKey):
                            COURSE.pop(popKey)
                            code = 202
                        elif tableName == "studcourse" and STUDCOURSE.has_key(popKey):
                            STUDCOURSE.pop(popKey)
                            code = 202
                        elif tableName == "courseoffering" and COURSEOFFERING.has_key(popKey):
                            COURSEOFFERING.pop(popKey)
                            code = 202
                        elif tableName == "studenthistory" and STUDENTHISTORY.has_key(popKey):
                            STUDENTHISTORY.pop(popKey)
                            code = 202
                        else:
                            code = 406
                    try:
                        Thread(target= saveTable, args=(tableName,)).start() 
                    except:
                        print("File is busy...")
                        pass
                           
    else:
        code = 202
        if tableName == "student":
            STUDENT.clear()
        elif tableName == "course":
            COURSE.clear()
        elif tableName == "studcourse":
            STUDCOURSE.clear()
        elif tableName == "courseoffering":
            COURSEOFFERING.clear()
        elif tableName == "studenthistory":
            STUDENTHISTORY.clear()
        else:
            code = 408

    try:
        Thread(target= saveTable, args=(tableName,)).start() 
    except:
        print("File is busy...")
        pass

def selectData(tableName,parsed):
    global code
    global tbldata
    global headers

    if (isinstance(parsed.tokens[-1], Where)):
        operator = ""
        conditions = []
        outgoingData = {}
       
        for case in parsed.tokens[-1]:
            
            if isinstance(case,Comparison):
                tempCon = []
                for compItem in case.tokens:

                    if isinstance(compItem,Identifier):
                        tempCon.append(re.sub('"','',compItem.value))
                    else:
                        if not compItem.value.strip() == '':
                            tempCon.append(compItem.value)
                conditions.append(tempCon)

            else:
                if str(case) == "and" :
                    if not operator == "":
                        code = 407
                    else:
                        operator = "and"
                elif str(case) == "or" :
                    if not operator == "":
                        code = 407
                    else:
                        operator = "or"
                else:
                    if not str(case) == "where" and not str(case) == ";" and not str(case).strip() == "":
                        code = 407
        if len(conditions) > 1 and operator == "":
            code = 407       

        if tableName =="student":
            targetTable = STUDENT
            colList = list(studentDict.keys())
        elif tableName == "course":
            targetTable = COURSE
            colList = list(courseDict.keys())
        elif tableName == "studcourse":
            targetTable = STUDCOURSE
            colList = list(studcourseDict.keys())
        elif tableName == "courseoffering":
            targetTable = COURSEOFFERING
            colList = list(courseofferingDict.keys())
        elif tableName == "studenthistory":
            targetTable = STUDENTHISTORY
            colList = list(studenthistoryDict.keys())
        else:
            code = 408
        
        if not code == 408 and not code == 407:

            for cond in conditions:
                if not cond[0] in colList:
                    code = 404
             
            if not code == 404 :

                for key,data in targetTable.iteritems():
                    results = []
                    tagged = False
                    
                    for cond in conditions:
                        try:
                            
                            if cond[0] in integerList and cond[2].isdigit():
                                valB = int(cond[2])
                                valA = int(data[colList.index(cond[0])])
                            elif cond[0] in dateList:
                                valB = time.strptime(cond[2],"%Y-%m-%d" )
                                valA = time.strptime(data[colList.index(cond[0])],"%Y-%m-%d")
                            elif cond[0] in timeList:
                                valB = time.strptime(cond[2], "%H:%M" )
                                valA = time.strptime(data[colList.index(cond[0])], "%H:%M" )
                            else:
                                valB = cond[2]
                                valA = data[colList.index(cond[0])]
                            
                      
                            if cond[1] == '=' :
                                if valA == valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            elif cond[1] == '<' :
                                if valA < valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            elif cond[1] == '>' :
                                if valA > valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            elif cond[1] == '<=' :
                                if valA <= valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            elif cond[1] == '>=' :
                                if valA >= valB:
                                    results.append(True)
                                else:
                                    results.append(False)
                            else:
                                code = 406
                            
                        except:
                            code = 406
                            
                    
                    if not operator == '' and not code == 406:
                        if operator == 'and':
                            tagged = results[0] * results[1]
                        elif operator == 'or':
                            tagged = results[0] + results[1]
                        else:
                            code = 406
                    else:
                        tagged = results[0]

                    if tagged:
                        outgoingData[key]=data
             
                if str(type(parsed.tokens[2])) == "<class 'sqlparse.sql.Token'>":
                    
                    code = 200
                    headers = colList
                    
                    for key in outgoingData:
                        tbldata[key]=outgoingData[key]
                    

                else:
                    code = 200
                    colFilterList = []
                    indexList = []

                    for colName in str(parsed.tokens[2]).split(","):
                        colFilterList.append(colName.strip())
                        headers.append(colName)


                    if tableName == "student":
                        tableCols = list(studentDict.keys())
                        for checkCol in colFilterList:
                            if checkCol in tableCols:
                                indexList.append(tableCols.index(checkCol))
                            else:
                                code = 404
                                break
        
                    elif tableName == "course":
                        tableCols = list(courseDict.keys())
                        for checkCol in colFilterList:
                            if checkCol in tableCols:
                                indexList.append(tableCols.index(checkCol))
                            else:
                                code = 404
                                break
                        
                    elif tableName == "studcourse":
                        tableCols = list(studcourseDict.keys())
                        for checkCol in colFilterList:
                            if checkCol in tableCols:
                                indexList.append(tableCols.index(checkCol))
                            else:
                                code = 404
                                break
                        
                    elif tableName == "courseoffering":
                        tableCols = list(courseofferingDict.keys())
                        for checkCol in colFilterList:
                            if checkCol in tableCols:
                                indexList.append(tableCols.index(checkCol))
                            else:
                                code = 404
                                break

                    elif tableName == "studenthistory":
                        tableCols = list(studenthistoryDict.keys())
                        for checkCol in colFilterList:
                            if checkCol in tableCols:
                                indexList.append(tableCols.index(checkCol))
                            else:
                                code = 404
                                break
                    else:
                        code = 408

                    if code == 200 :

                        for tupleEntry in outgoingData:
                            tupleData = []
                            for i in indexList:
                                tupleData.append(outgoingData[tupleEntry][i])
                                                    
                            tbldata[tupleEntry]= tupleData


    #END OF SELECT WITH WHERE AND WITHOUT *  ------------------------------------------
    
    
    else:
       
        if str(type(parsed.tokens[2])) == "<class 'sqlparse.sql.Token'>":
            code = 200
            if tableName == "student":
                headers= list(studentDict.keys())
                for data in STUDENT.iteritems():
                    tbldata[data[0]]=data[1]
            elif tableName == "course":
                headers= list(courseDict.keys())
                for data in COURSE.iteritems():
                    tbldata[data[0]]=data[1]
            elif tableName == "studcourse":
                headers= list(studcourseDict.keys())
                for data in STUDCOURSE.iteritems():
                    tbldata[data[0]]=data[1]
            elif tableName == "courseoffering":
                headers= list(courseofferingDict.keys())
                for data in COURSEOFFERING.iteritems():
                    tbldata[data[0]]=data[1]
            elif tableName == "studenthistory":
                headers= list(studenthistoryDict.keys())
                for data in STUDENTHISTORY.iteritems():
                    tbldata[data[0]]=data[1]
            else:
                code = 408
            
        else:

            code = 200
            colFilterList = []
            indexList = []

            for colName in str(parsed.tokens[2]).split(","):
                colFilterList.append(colName.strip())
                headers.append(colName)

            if tableName == "student":
                tableCols = list(studentDict.keys())
                for checkCol in colFilterList:
                    if checkCol in tableCols:
                        indexList.append(tableCols.index(checkCol))
                    else:
                        code = 404
                        break
                for tupleEntry in STUDENT.iteritems():
                    tupleData = []
                    for i in indexList:
                        tupleData.append(tupleEntry[1][i])
                    tbldata[tupleEntry[0]]= tupleData
  
            elif tableName == "course":
                tableCols = list(courseDict.keys())
                for checkCol in colFilterList:
                    if checkCol in tableCols:
                        indexList.append(tableCols.index(checkCol))
                    else:
                        code = 404
                        break
                for tupleEntry in COURSE.iteritems():
                    tupleData = []
                    for i in indexList:
                        tupleData.append(tupleEntry[1][i])
                    tbldata[tupleEntry[0]]= tupleData
                
            elif tableName == "studcourse":
                tableCols = list(studcourseDict.keys())
                for checkCol in colFilterList:
                    if checkCol in tableCols:
                        indexList.append(tableCols.index(checkCol))
                    else:
                        code = 404
                        break
                for tupleEntry in STUDCOURSE.iteritems():
                    tupleData = []
                    for i in indexList:
                        tupleData.append(tupleEntry[1][i])
                    tbldata[tupleEntry[0]]= tupleData
                
            elif tableName == "courseoffering":
                tableCols = list(courseofferingDict.keys())
                for checkCol in colFilterList:
                    if checkCol in tableCols:
                        indexList.append(tableCols.index(checkCol))
                    else:
                        code = 404
                        break
                for tupleEntry in COURSEOFFERING.iteritems():
                    tupleData = []
                    for i in indexList:
                        tupleData.append(tupleEntry[1][i])
                    tbldata[tupleEntry[0]]= tupleData

            elif tableName == "studenthistory":
                tableCols = list(studenthistoryDict.keys())
                for checkCol in colFilterList:
                    if checkCol in tableCols:
                        indexList.append(tableCols.index(checkCol))
                    else:
                        code = 404
                        break
                for tupleEntry in STUDENTHISTORY.iteritems():
                    tupleData = []
                    for i in indexList:
                        tupleData.append(tupleEntry[1][i])
                    tbldata[tupleEntry[0]]= tupleData
            else:
                code = 408
            

    

    
    







