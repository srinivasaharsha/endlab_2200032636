
<html>
<body>
    <h1>Welcome to the CRUD Operations Application</h1>
    <h2>All Records</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Department</th>
            <th>Action</th>
        </tr>

        <c:forEach var="record" items="${records}">
            <tr>
                <td>${record.id}</td>
                <td>${record.name}</td>
                <td>${record.department}</td>
                <td>
                    <a href="crud-operations/edit/${record.id}">Edit</a> |
                    <a href="crud-operations/delete/${record.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <form action="crud-operations/" method="post">
        <input type="text" name="name" placeholder="Name" required />
        <input type="text" name="department" placeholder="Department" required />
        <button type="submit" name="action" value="add">Add Record</button>
    </form>
</body>
</html>
