// This file was generated by Mendix Modeler.
//
// WARNING: Code you write here will be lost the next time you deploy the project.

package slackmessage.proxies;

public enum Enum_SlashCommand_RequestValidation
{
	ok(new java.lang.String[][] { new java.lang.String[] { "en_US", "Ok" } }),
	invalidtoken(new java.lang.String[][] { new java.lang.String[] { "en_US", "Invalid token" } }),
	oksslcheck(new java.lang.String[][] { new java.lang.String[] { "en_US", "Ok SSL check" } }),
	invalidtokensslcheck(new java.lang.String[][] { new java.lang.String[] { "en_US", "Invalid token SSL check" } });

	private java.util.Map<java.lang.String, java.lang.String> captions;

	private Enum_SlashCommand_RequestValidation(java.lang.String[][] captionStrings)
	{
		this.captions = new java.util.HashMap<java.lang.String, java.lang.String>();
		for (java.lang.String[] captionString : captionStrings)
			captions.put(captionString[0], captionString[1]);
	}

	public java.lang.String getCaption(java.lang.String languageCode)
	{
		if (captions.containsKey(languageCode))
			return captions.get(languageCode);
		return captions.get("en_US");
	}

	public java.lang.String getCaption()
	{
		return captions.get("en_US");
	}
}
