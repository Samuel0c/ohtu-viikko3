package statistics.matcher;

import java.util.LinkedList;
import java.util.List;

public class QueryBuilder {

    Query query;
    List<Matcher> matchers;

    public QueryBuilder() {
        query = new Query();
        this.matchers = new LinkedList<>();
    }

    public Query pino() {
        return query;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder and(Matcher... matchers) {
        this.matchers.add(new And(matchers));
        return this;
    }
    
    public QueryBuilder not(Matcher matcher) {
        this.matchers.add(new Not(matcher));
        return this;
    }
    
    public QueryBuilder or(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }
    
    public Matcher build() {
        return new And(this.matchers.toArray(new Matcher[this.matchers.size()]));
    }
}
