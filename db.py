import mysql.connector
#from mysql.connector import Error
#import cx_Oracle

conn = mysql.connector.connect(host = "database-anu.cb4eswumqqcs.us-east-1.rds.amazonaws.com", 
                              user = "admin",
                              passwd = "admin123",
                              database = "mydb")  

if conn.database!="mydb":
    print("Not successful")
else:
    print("conn working")