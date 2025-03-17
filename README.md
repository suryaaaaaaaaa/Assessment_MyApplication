This is an assessment application.
Here, used multi module architecture with hilt and clean architecture 
there module mainly been used core , network, feature.
core - all utill classes and common cleasses being added.
network - all network related classes being added
feature- it specify and contains feature related stuff which sub categoriezed among ui, domain, data
ui - contains designs or view classes using jetpack compose
domain- contains classes related to implemntation (business logic)
data- holds the model classes and mapper classes
to install directly after clone the prject directly run the project.


Folder Structure
Core Module-> Network module
di: NetworkModule provides global dependencies
api- ApiService for api calls,CarsSearchResponse for api response, CarsRepository to provide function to fetch data wherever it is required.

Common module 
Uievent - which is commonn class 

Data Module:
di: DataLayerModule and repository binding
RepoImp - to bind and map data to data class.

Domain Module
di :DomainLayerModule binds domain dependencies
model CarSearchResponseItem hold the data and mapped from reponse
usecase: GetCarsListUseCase to retrive car list, GetImageUseCase to fetch image

ui module
screen :CarSearchScreen show list of cars
util - contains all the gerenric class such as LoadingBar
CarSearchStateHolder- hold the state of CarSearchScreen
ToolbarWidget- show app bar
View Model - bind the usecases and call the api using lauch coroutine.






![WhatsApp Image 2025-03-14 at 8 55 20 PM](https://github.com/user-attachments/assets/63ebaf62-a61e-43af-a3d9-797e1ad4159c)



![WhatsApp Image 2025-03-14 at 8 55 20 PM (1)](https://github.com/user-attachments/assets/bec24a82-0828-4a67-a29a-c3e9bce687e6)
