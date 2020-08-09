var request = { 
	QueryString : function(val) { 
		var uri = window.location.search; 
		var re = new RegExp("" +val+ "\=([^\&\?]*)", "ig"); 
		return ((uri.match(re))?(uri.match(re)[0].substr(val.length+1)):null); 
	}
}