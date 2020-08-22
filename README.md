1. REST API: http://localhost:8888/rec/{movie_genre_preference}
    - {movie_genre_preference}: list of user's movie genre preference
    - e.g:
        http://localhost:8888/rec/1,2 --> get movie suggestions for genre preference has id 1 (action) and 2 (comedy) 
2. Database (use text file for demo)
    - movie_db:
        + id
        + name
        + rating
        + genres
    - genre_db:
        + id
        + name
         