# About

This project demonstrates a database constrain when the order of the engines is not correctly setup.
This constraint is met when starting a case instance.
Forum topic: https://forum.flowable.org/t/issue-when-starting-a-cmmn-instance/5115 

## How to

- Create a postgresql database flowabledb with owner flowable and password flowable.
- Start the project using your IDE's and Spring boot profile runners or the command line.
- Invoke the post request http://localhost:8080/cmmn/start/tcd you will see an error 