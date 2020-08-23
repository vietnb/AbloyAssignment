package abloy.assignment.business;

public interface IRecommendation<I, O> {
    public O recommend(I input);
}
