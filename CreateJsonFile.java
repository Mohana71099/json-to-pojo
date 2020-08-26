package sample;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;
import com.sun.codemodel.JCodeModel;
public class CreateJsonFile {

	public static void main(String[] args) {
		String packageName="com.cooltrickshome";
		File inputJson=new File("."+File.separator+"input.json");
		File outputPojoDirectory=new File("."+File.separator+"ConvertedPojo");
        outputPojoDirectory.mkdirs();
        try
        {
        	new CreateJsonFile().convert2JSON(inputJson.toURI().toURL(),outputPojoDirectory, packageName,InputJSON.getName().replace(". json",""));
        }
        catch(IOException e)
        {
        	System.out.println(Encountered issue while converting to pojo: "+e.getMessage());
        			e.printStackTrace();
        }
	}
	public void convert2JSON(URL inputJson , File outputPojoDirectory, String packageName,String className) throws IOException
	{
		JCodeModel codeModel = new JCodeModel();
		URL source = inputJson;
		GenerationConfig config = new DefaultGenerationConfig()
				{
			@Override
			public boolean getSourceType()
			{
				return true;
			}
			public SourceTpye getSourceType()
			{
				return SourceType.JSON;
			}
		};
		SchemaMapper mapper = new Schemamapper(new RuleFactory(config,new Jackson2Annotator(config),new SchemaStore()),new SchemaGenerator());
		mapper.generate(codeModel,className,packageName,source);
		codeModel.build(outputPojoDirectory);
	}
}
package sample;

public class inputJSON {
	private String about,created,id,likes;
	String submitted [] = new String [1];
public inputJSON()
{
	//default constructor
}
public inputJSON(String about,String created,string id;string likes)
{
	this.about=about;
	this.created=created;
	this.id=id;
	this.likes=likes;
}
public void setabout(String about)
{
	this.about=about;
}
public void getabout(String about)
{
	return this.about;
}
public void setcreated(String created)
{
	this.created=created;
}
public void getcrtedea(String created)
{
	return this.created;
}
public void setid(String id)
{
	this.id=id;
}
public void getid(String id)
{
	return this.id;
}
public void setlikes(String likes)
{
	this.likes=likes;
}
public void getlikes(String likes)
{
	return this.likes;
}
}
