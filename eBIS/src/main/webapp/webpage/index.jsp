
<html>
<body>
<% 
String status="Home";
if(status.equals("Home")){
%>
<script>
	location.href="/eBIS/Home"; 
</script>
<%}else if(status.equals("maintenance")){%>
<script>
	location.href="/eBIS/UnderMaintainance";
</script>
<%}%>
</body>
</html>

