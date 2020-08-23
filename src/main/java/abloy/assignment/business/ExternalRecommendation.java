package abloy.assignment.business;

import abloy.assignment.service.so.ExternalRequestParams;
import abloy.assignment.service.so.MovieSuggestion;

import java.util.List;

public class ExternalRecommendation implements
        IRecommendation<ExternalRequestParams, List<MovieSuggestion>> {

    public List<MovieSuggestion> recommend(ExternalRequestParams input) {
        // TODO: call api from Netflix or IMDC ...
        return null;
    }
}
