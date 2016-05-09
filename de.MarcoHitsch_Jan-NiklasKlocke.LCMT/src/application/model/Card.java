package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.rmi.server.UID;
import java.util.ArrayList;

/**
 * Created by peach on 5/7/16.
 */
public class Card {

    private StringProperty question;
    private StringProperty article;
    private StringProperty category;
    private StringProperty context;
    private StringProperty id;
    private ArrayList<String> keyWords;

    public Card(String question,
                String article,
                String category,
                String context,
                String... keyWords){
        this.question = new SimpleStringProperty(question);
        this.article = new SimpleStringProperty(article);
        this.category = new SimpleStringProperty(category);
        this.context = new SimpleStringProperty(context);
        this.id = new SimpleStringProperty(new UID().toString());
        this.keyWords = new ArrayList<String>();
        for (String word:keyWords){
            this.keyWords.add(word);
        }
    }

    public String getQuestion() {
        return this.question.get();
    }

    public void setQuestion(String question) {
        this.question.setValue(question);
    }

    public StringProperty questionProperty() {
        return question;
    }

    public String getArticle() {
        return this.article.get();
    }

    public void setArticle(String article) {
        this.article.setValue(article);
    }

    public StringProperty articleProperty() {
        return article;
    }

    public String getCategory() {
        return this.category.get();
    }

    public void setCategory(String category) {
        this.category.setValue(category);
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public String getContext() {
        return this.context.get();
    }

    public void setContext(String context) {
        this.context.setValue(context);
    }

    public StringProperty contextProperty() {
        return context;

    }

    public String getId() {
        return this.id.get();
    }

    public void setId(String id) {
        this.id.setValue(id);
    }

    public StringProperty idProperty() {
        return id;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(ArrayList<String> keyWords) {
        this.keyWords = keyWords;
    }

    public void addKeyword(String keyWord){
        this.keyWords.add(keyWord);
    }

    public void removeKeyword(String keyWord){
        try{
            this.keyWords.remove(keyWord);
        } catch (Exception e){
            //Todo add Exception handling
        }
    }

    public String getKeyWordsAsString(){
        return  this.keyWords.toString(); //ToDo more Userfreandly solution
    }
}
