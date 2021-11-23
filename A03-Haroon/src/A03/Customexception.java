package A03;


public class Customexception {
public void populateData() throws Exception1
{
throw new Exception1("Please Populate BsT");	
}
public void NullException(String a) throws Exception1
{
	if(a.equals(null)||a.equals(""))
	{
		throw new Exception1("Cannot Insert Null");
	}
}

}
