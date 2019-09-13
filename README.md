# taskMaster
### URL: http://newenv.iam9ckq2yg.us-west-2.elasticbeanstalk.com

---

## Routes
##### Get: http://newenv.iam9ckq2yg.us-west-2.elasticbeanstalk.com/api/v1/tasks
"/api/v1/tasks" - This route will dispaly all tasks in the database.
Postman input > http://newenv.iam9ckq2yg.us-west-2.elasticbeanstalk.com/api/v1/tasks

##### PUT: http://newenv.iam9ckq2yg.us-west-2.elasticbeanstalk.com/api/v1/tasks/{id}/state
"/api/v1/tasks/{id}/status" - This route will advance the status 1 step closer to finished.
Postman input > http://newenv.iam9ckq2yg.us-west-2.elasticbeanstalk.com/api/v1/tasks/aca8c45a-685f-47cf-b1e2-46e20c006aec/state  
Note: Finished tasks are not updated past Finished status.

##### POST: http://newenv.iam9ckq2yg.us-west-2.elasticbeanstalk.com/api/v1/tasks
"/api/v1/tasks" - This route will add a new task into the database so long as the requestbody is structured like the task object's JSON is.
Postman input > http://newenv.iam9ckq2yg.us-west-2.elasticbeanstalk.com/api/v1/tasks
Postman body > {"title":"title Value", "description":"description Value"}
