# taskMaster
### URL: http://newenv.iam9ckq2yg.us-west-2.elasticbeanstalk.com
---

## Routes
##### Get:
"/api/v1/tasks" - This route will dispaly all tasks in the database.

##### PUT:
"/api/v1/tasks/{id}/status" - This route will advance the status 1 step closer to finished.

##### POST:
"/api/v1/tasks" - This route will add a new task into the database so long as the requestbody is structured like the task object's JSON is.
