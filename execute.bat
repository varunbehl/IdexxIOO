echo "idexx automation suite exceution"
echo " ===creating dynamic xml from excel ==="
cd C:\Users\Administrator\Desktop\IdexxFrameWork

java -cp .\\lib\\*;.\\target\\test-classes;.\\target\\classes; com.automation.utilities.ExcelToXml

mvn clean test -DsuiteXmlFile=testng.xml
pause