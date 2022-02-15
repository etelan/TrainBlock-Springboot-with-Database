# PostgresqlAndSpringBoot
This project allows us to take requests from our minecraft server, using the [OpenComputers ImersiveRailroading api](https://github.com/TeamOpenIndustry/ImmersiveRailroading/wiki/Open-Computers).

## Front End
This is the [Front End Github Repo](https://github.com/etelan/TrainBlock-Site).  
And the actual [hosted site](https://alexisbaker.uk/TrainBlock-Site/)
I will make this interface with this backend soon, and connect up the menu with the different pages.

It is unsurprisingly modelled on the [Trainline Site](https://www.thetrainline.com/)

## Supported Methods

This is laid out like the following. 
/addTrain?tag="skjdha"&station="Mars"&passHash="skdasSKLJdsD48298SnSDJnK"

addTrain tag station passHash  
showAll passHash  
countTrains passHash  
noperms  
findTrainById id passHash  
updateTrainById id passHash stationName  
deleteTrain passHash id  

## Why did you make this 
I wanted to learn springboot, and have more experiences with databases.  
In previous projects I was having difficulty closing the database connection, now, springboot handles it all for us using repositories.  
Additionally, I wanted to make a cool tracker for the minecraft server I play on.
