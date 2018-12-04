from BTrees.OOBTree import OOBTree

studentDict =  {
    "studno":[1,"char"],
    "studentname":[2,"char"],
    "birthday":[3,"char"],
    "degree":[4,"char"],
    "major":[5,"char"],
    "unitsearned":[6,"int"]
}

courseDict = { 
    "cno":[1,"char"], 
    "ctitle":[2,"char"], 
    "cdesc":[3,"char"], 
    "noofunits":[4,"int"], 
    "haslab":[5,"int"],
    "semoffered":[6,"char"]
}

courseofferingDict = {
    "semester":[1,"char"], 
    "acadyear":[2,"char"], 
    "cno":[3,"char"], 
    "section":[4,"char"],
    "time":[5,"char"], 
    "maxstud":[6,"int"]
}

studcourseDict = {
    "studno":[1,"char"], 
    "cno":[2,"char"], 
    "semester":[3,"char"],
    "acadyear":[4,"char"]
}

studenthistoryDict =  {
    "studno":[1,"char"], 
    "description":[2,"char"], 
    "action":[3,"char"], 
    "datefiled":[4,"char"],
    "dateresolved":[5,"char"]
} 


STUDENT = OOBTree()
STUDCOURSE = OOBTree()
STUDENTHISTORY = OOBTree()
COURSE = OOBTree()
COURSEOFFERING = OOBTree()

integerList = ['unitsearned','noofunits','haslab','maxstud']
dateList = ['birthday','datefiled','dateresolved']
semList = ['semester','semoffered']
timeList = ['time']
