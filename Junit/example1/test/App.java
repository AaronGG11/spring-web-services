public class App
{
    private String name;
    private String language;

    public App(String name, String language)
    {
        this.name = name;
        this.language = language;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public static String Saludar(String name)
    {
        return "Hello " + name;
    }

    public static String Despedir(String name)
    {
        return "Bye " + name;
    }
}
