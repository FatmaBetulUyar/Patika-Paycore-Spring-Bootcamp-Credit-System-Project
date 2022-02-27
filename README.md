
<h2>PATİKA.DEV - PAYCORE JAVA SPRİNG BOOTCAMP GRADUATION PROJECT</h2> 

<p>This graduation project is a Credit System Project.</p>

<h3>📚 SUBJECT OF PROJECT </h3>
<p>Writing a <b>Restful Application</b> for a credit application system, which will take the credit application requests and return the loan result to the customer according to the relevant criteria, using the  <b>Spring Boot framework </b> and optionally writing the frontend</p>
<h4>✏️ APPLICATION FORM & RESULT </h4>
<div>
<img src="src/main/resources/static/assets/Form.png" style="width:400px; margin-left:400px ;margin-top:30px">

<img src="src/main/resources/static/assets/Response.png" style="width:400px;margin-left:400px ;margin-top:30px">
</div>


<h4>📝  UML DIAGRAM</h4> 

<img src="src/main/resources/static/assets/uml_diagram.png" style="width:330px; height: auto ;margin-left:400px ; margin-top:30px ">

<h4>📝 DATABASE DIAGRAM</h4> 

<img src="src/main/resources/static/assets/database.png" style="width:350px; height: auto ;margin-left:400px ; margin-top:30px " >

<h4>📝 REQUİREMENTS</h4>
<ol>
<li>The user's <b>identity number, name-surname, monthly income and telephone </b> information are obtained, <br>
(There may be two options as <b>✅ Approval</b> or <b>❌ Rejection</b>.) </li>
<li> The <b>credit score service</b> is assumed to be written with the identity number before, and the credit score of the relevant person is obtained</li>
<li>And the credit result is shown to the user according to the following rules.</li>
<ul>
<li>
<b>New users</b> can be <b>defined</b>  in the system, existing customers can be <b>updated</b> or <b>deleted</b>.</li>
<li>If the <b>credit score</b>  is <b>below 500</b>, the user will be rejected. <b>(Credit result: Reject ❌ )</b></li>
<li>If the <b>credit score</b> is <b>between 500</b> points and <b>1000</b> points<ul><li> And if the <b>monthly income</b>  is <b>below 5000 </b> TL <br>
The user's loan application is approved and a <b>limit of 10,000 TL</b>  is assigned to the user. <b>(Credit Result:
Approval ✅ )</b>
</li></ul></li>
<li>
If the <b>credit score</b>  is <b>between 500</b> points and <b>1000 </b>points <ul><li>And if the <b>monthly income</b> is <b>above 5000 </b>TL<br>
The loan application of the user is approved and a <b>limit of 20.000 TL</b>   is assigned to the user.<b>(Credit Result:
Approval ✅ )</b> 
</li>
</ul></li>
<li>
If the <b>credit score</b>  is <b>equal</b> to or <b>above 1000</b>  points, the user will receive <b> Monthly Income * Credit Limit Multiplier</b>
The limit is assigned as much as the LIMIT MULTIPLIER. <b>(Credit Result:
Approval ✅ )</b>  <br>(The credit limit multiplier is 4 by default.) </li>
</ul>
<li>As a result of the conclusion of the loan, the relevant <b>application</b> is <b>recorded</b> in the <b>database</b> .</li>
<li>Later
by <b>sending a notification SMS</b> to the relevant phone number, confirmation <b> status </b>information and <b>limit </b>information are <b>returned</b> from the endpoint.</li>
<li>A completed loan application <b>can only be queried</b> with an <b>Identity number.</b> </li>
</ol>

<h4>📝 BUILD WITH</h4>
<div>
<img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" >
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white">
</div>
<h4>📝 TECHNOLOGIES </h4>
<ul>
<li><b>Spring Boot</b></li>
<li><p><b>API Documentation</b> ➡️ <b>Swagger UI</b></p>
<p>
I included Swagger in my project because its purpose is to provide an interface for RestApi's.</p>
</li>
<li><p><b>ORM</b> ➡️ <b>JPA/Hibernate</b></p>
<p>Hibernate doesn't just convert from Java classes to database tables or from Java data types to SQL data types. Hibernate also provides data query and data retriaval operations for the user. With these features, Hibernate provides ease of development and saves time.So I used Hibernate.</p></li>
<li><p><b>Build Tool</b> ➡️ <b>Maven</b> </p>
<p>
I used Maven because it provides easy tracking of projects thanks to the standard file-directory structure it provides.
</p></li>
<li><p><b>Unıt Test</b> ➡️ <b>Junit</b></p>
<p>
Junıt simplifies testing and shortens this time by offering a variety of additional features.That's why I added it to my project.</p></li>
<li><b>Lombok</b><p>I used Lombok when developing Java applications because it is a code generation library with the help of annotation that allows us to write less and cleaner code, facilitate readability</p></li>
<li><b>React JS</b><p>
I used ReactJs because it is a very powerful framework with its flexible structure, re-usable components and state management.</li>
<li><b>Bootstrap</b><p>I used it for convenience for design</p></li>
<li><b>Axios</b><p>I used it to pull data from API</p></li>
</ul>
<h4>📝 ENDPOINTS </h4>
<img src="src/main/resources/static/assets/swagger_endpoints.png">
<h4>📝 ARCHITECTURE </h4>
