/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author nabil.ouerhani
 */
public class MoreInfoRequest
{
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCourses() {
    return courses;
  }
  public void setCourses(String courses) {
    this.courses = courses;
  }

  public String getEmail() {
    return email;
  }
    public void setEmail(String email) {
    this.email = email;
  }

  private String firstName;
  private String lastName;
  private String email;
  private String courses;
}

