from flask import Flask, render_template, request, jsonify, session, redirect
from antlr4 import *
from antlr4.error.ErrorListener import ErrorListener
from gramLexer import gramLexer
from gramParser import gramParser
from gramListener import gramListener
import sys
import re
import time
import os
from werkzeug import secure_filename
from threading import Thread
from transaction import *

app = Flask(__name__)
qryError = False
qryErrorMsg = ""
app.config['UPLOAD_FOLDER'] = "upload"
app.secret_key = 'bdf8c4a8978844e1c6e1f862187c869f'


class MyErrorListener( ErrorListener ):
    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        global qryError
        global qryErrorMsg
        qryError = True
        qryErrorMsg = str(line) + ":" + str(column) + ": syntax ERROR, " + str(msg)
        pass
    def reportAmbiguity(self, recognizer, dfa, startIndex, stopIndex, exact, ambigAlts, configs):
        global qryError
        global qryErrorMsg
        qryError = True
        qryErrorMsg = "Ambiguity ERROR, " + str(configs)
        pass
    def reportAttemptingFullContext(self, recognizer, dfa, startIndex, stopIndex, conflictingAlts, configs):
        global qryError
        global qryErrorMsg
        qryError = True
        qryErrorMsg = "Attempting full context ERROR, " + str(configs)
        pass
    def reportContextSensitivity(self, recognizer, dfa, startIndex, stopIndex, prediction, configs):
        global qryError
        global qryErrorMsg
        qryError = True
        qryErrorMsg = "Context ERROR, " + str(configs)
        pass


@app.route("/")
def mainpageindex():
    return render_template("./mainpage/index.html")

@app.route('/uploader',methods=['POST','GET'])
def uploader():

    if request.method == 'POST':
        tableName = request.form['selectedTable'].strip()
        f = request.files['file']
        filePath = os.path.join(app.config['UPLOAD_FOLDER'],secure_filename(f.filename))
        f.save(filePath)

        
        code = uploadInsert(filePath,tableName)
    
        return render_template("./confirmation/index.html",code = code)



@app.errorhandler(404)
def error404(error):
    return render_template("./mainpage/index.html")


@app.route("/query",methods=['POST'])
def query():
    global qryError
    global qryErrorMsg
    msg = "Done it the way it should."

    code = 202
    tbl = []
    headers = []
    start_time = time.time()
    qry = request.form['qry'].strip().lower()
    parsedStatement = sqlparse.parse(qry)
    
    for parsed in parsedStatement:
        qry = str(parsed)
        tree = validate(qry)
        try:
            if qryError:
                msg = qryErrorMsg
                break
            else:
                statementType = parsed.get_type()
                tableName = parsed.get_name()
                code,tbl,headers = processQry(parsed,statementType,tableName)
                pass
        except:
            code = 407
            pass
    
    if code == 200:
        resultCount = len(tbl[0])
    else:
        resultCount = 0

    return jsonify({'msg' : msg, 'code' : code, 'qryError' : qryError , 'qtime': time.time() - start_time,'tbl':tbl,'resultCount':resultCount, 'headers':headers})

def validate(strIn):
    global qryError
    qryError = False
    inp = InputStream(strIn)
    lexer = gramLexer(inp)
    stream = CommonTokenStream(lexer)
    parser = gramParser(stream)
    parser._listeners = [ MyErrorListener() ]
    tree = parser.r()
    return tree


if __name__ == "__main__":

    print("Initializing juanDB...")
    if loadTables() :
        print("Tables loaded successfuly...")
    else:
        print("Failed to load tables properly...")
    
    
    app.run(host= '0.0.0.0',port=80,debug=True) # change to False later

    
