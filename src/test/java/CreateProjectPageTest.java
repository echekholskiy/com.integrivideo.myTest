import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateProjectPageTest extends BasicPageTest{
    public CreateProjectPage CPP;
    public ProjectPage PP;
    public LogInPage LP;
    public InProjectPage IPP;
    public String project="project test";
    public String description="description test";
    public String domen="test.by";

    @Before
    public void settings(){
        LP=MP.clickLogIn();
        PP=LP.LogIn("integriuser2@mailinator.com", "integripassword");
        CPP=PP.clickAddProject();
        CPP.addProject(project, description, domen);
        IPP=PP.clickLastOfProject();
    }

    @Test
    public void ProjectFieldTest(){
        Assert.assertEquals(IPP.getProjectName(), project);
        Assert.assertEquals(IPP.getDescription(), description);
    }


}
