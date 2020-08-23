1. REST API: http://{host}:{port}/rec/{movie_genre_preference}
    - {host} 
    - {port}
    - {movie_genre_preference}: list of user's movie genre preference
    - e.g: http://localhost:8888/rec/1,2
        --> get movie suggestions for genre preference has id 1 (action) and 2 (comedy)
        
2. Recommendations from external services like Netflix and IMDB
    The business layer has two types of Recommendation:
    - InternalRecommendation: currently used assuming I don't have access to Netflix's or IMDB's API yet. 
    - ExternalRecommendation: in case I have access to those APIs. 
        We can later define the params in ExternalRequestParams to request to external APIs and 
        to parse the data returning from those APIs into our own data format. 

3. For more detail information, please check 'doc/architecture_design.docx'
         