/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saveideas;

/**
 *
 * @author ASUS
 */
public class Ideas {

    public Ideas(int id, String title, String author, String idea, String type, String date) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.idea = idea;
        this.type = type;
        this.date = date;
    }
  
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIdea() {
        return idea;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    private Integer id;
    private String title;
    private String author;
    private String idea;
    private String type;
    private String date;
    
}
