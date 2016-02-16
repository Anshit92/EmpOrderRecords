#echo "<?xml version=\"1.0\" encoding=\"utf-8\"?>
#       <Context><WatchedResource>WEB-INF/web.xml</WatchedResource>

#       </Context>"  > /etc/tomcat7/context.xml ;

#cat /etc/tomcat7/context.xml;
service tomcat7 start ;
tail -f /var/lib/tomcat7/logs/catalina.out