<%@page import="com.blog.connection.ConnectionProvider"%>
<%@page import="com.blog.Dao.PostDao"%>
<%@page import="com.blog.Dao.LikedDao"%>

<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.blog.Servlets.*"%>
<%@page import="com.blog.entities.*"%>
<%@page import="com.blog.entities.Category"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bootstrap Modal Example</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./style.css" type="text/css">


<style type="text/css">
table, tr, th {
	border: 2px solid;
	
	
	
}
}





</style>



</head>
<body>
<!-- <script>
  window.fbAsyncInit = function() {
    FB.init({
      appId            : '181525803996275',
      xfbml            : true,
      version          : 'v18.0'
    });
  };
</script>
<script  src="https://connect.facebook.net/en_US/sdk.js"></script>
<div class="fb-comments" data-href="http://localhost:9494/Blog/profile.jsp" data-width="" data-numposts="10"></div> -->
	<!-- Navbar Section -->
	<nav class="navbar navbar-expand-lg navbar-light bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand text-white" href="index.jsp">Home</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link text-white"
						href="Register_Login/register.jsp">Register</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-white" href="#" role="button"
						data-bs-toggle="dropdown" aria-expanded="false"> Dropdown </a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item"  data-bs-toggle="modal" data-bs-target="#exampleModal" href="#">Add Blog</a></li>
							<li><a class="dropdown-item" href="EditBlogs.jsp">Edit Blogs</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
				</ul>
				<!-- Login Navbar on the Right Side -->
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link text-white"
						href="logout">Logout</a></li>
					<li class="nav-item"><a class="nav-link text-white" href="#"
						data-bs-toggle="modal" data-bs-target="#exampleModalLong"> <%
 User u = (User) session.getAttribute("user");
 if (u != null) {
 %> <i class="bi bi-person-fill"></i> <%=u.getName().toUpperCase()%> <%
 }
 %>
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Add Your Blog</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <!-- Form for table attributes -->
        <form id="blog" method="post" action="addpost" enctype="multipart/form-data">
          <div class="form-group">
            <label for="bName">Blog Name</label>
            <input type="text" class="form-control" id="bName" name="bName">
          </div>
          <div class="form-group">
            <label for="bContent">Blog Content</label>
            <textarea class="form-control" id="bContent" name="bContent" rows="4"></textarea>
          </div>
          <div class="form-group">
            <label for="author">Category</label>
            <select name="cid" class="form-control">
              <option selected disabled>-- Select Category --</option>
              <% 
                PostDao d = new PostDao(ConnectionProvider.getcon());
                ArrayList<Category> list = d.getAllCategory();
                for (Category c : list) {
              %>
              <option value="<%=c.getCid() %>"><%=c.getCtype() %></option>
              <% } %>
            </select>
          </div>
          <div class="form-group mt-3">
            <label for="author">Image</label>
            <input type="file" name="bImg" class="form-control-file">
          </div>
          <div class="text-center mt-4">
            <button type="submit" class="btn btn-secondary">Submit</button>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <!-- Additional footer content if needed -->
      </div>
    </div>
  </div>
</div>



	<!-- Modal -->
	<div class="modal fade" id="exampleModalLong" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h5 class="modal-title" id="exampleModalLongTitle">MY Profile</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>

				</div>
				<div class="modal-body" >

					<div class="conatiner text-center " id="profile">

						<img alt="" class="" src="img/<%=u.getImage()%>"
							style="width: 100px; border-radius: 30%;">
						<h1><%=u.getName().toUpperCase()%></h1>
						



							<table class="container text-center" style="width: 450px"
								border="2px">

								<tr>

									<td>ID</td>
									<td><%=u.getUdi()%></td>


								</tr>
								<tr>

									<td>Name:</td>
									<td><%=u.getName()%></td>


								</tr>
								<tr>

									<td>Gender:</td>
									<td><%=u.getGender()%></td>


								</tr>
								<tr>

									<td>About:</td>
									<td><%=u.getAbout()%></td>


								</tr>
								<tr>

									<td>About:</td>
									<td><%=u.getEmail()%></td>


								</tr>
								<tr>

									<td>Date:</td>
									<td><%=u.getDate().toString()%></td>


								</tr>
							</table>

						

					</div>
					
					<div class="container" id="edit" style="display: none;">
					
					<h1 >Edit</h1>
					<div class="container">
					
					<form action="edit2" method="post" enctype="multipart/form-data">
					
					<table style="width: 450px" border="2px">

								<tr>

									<td>ID</td>
									<td>
									
										<input name="id" type="text" value="<%=u.getUdi()%>" disabled="disabled">
									</td>


								</tr>
								<tr>

									<td>Name:</td>
									<td>
									<input name="name" type="text" value="<%=u.getName()%>">
									</td>
									


								</tr>
								<tr>

									<td>Gender:</td>
									<td>
									
										<input name="gender" type="text" value="<%=u.getGender()%>">
									</td>


								</tr>
								<tr>

									<td>About:</td>
									<td>
									
										<input name="about" type="text" value="<%=u.getAbout()%>" >
									</td>


								</tr>
								<tr>

									<td>mail:</td>
									<td>
									
										<input name="email" type="email" value="<%=u.getEmail()%>" >
									</td>


								</tr>
								<tr>

									<td>Img</td>
									<td>
									
										<input name="image" type="file" >
									</td>


								</tr>
								<tr>

									<td>Date:</td>
									<td>
									
										<input name="date" type="text" value="<%=u.getDate().toString()%>" disabled="disabled">
									</td>


								</tr>
								<tr>

									<td>Submit</td>
									<td>
									
										<input name="submit" type="submit" value="Submit">
									</td>


								</tr>
							</table>
					
					
					</form>
					
					</div>
					
					</div>
					
					

					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button id="btn" type="button" class="btn btn-primary">Update</button>
				</div>
			</div>
		</div>
	</div>
	<!-- ------------------------------------------------------------------------------------------------ -->
	
	
	
<div class="container mt-4">
  <h2 class="mb-4">Blog Posts</h2>
  <div class="row">
    <% 
      PostDao p = new PostDao(ConnectionProvider.getcon());
      ArrayList<Post> list_post = p.getAllPost(u.getUdi());
      
      for (Post post : list_post) {
        LikedDao liked = new LikedDao(ConnectionProvider.getcon());
        int l=liked.countLike(post.getP_id()); // Assuming LikedDao has a method to retrieve like count

        // Fetch other necessary data (e.g., comment count) similarly
        
    %>
    <div class="col-md-4 mb-4">
      <div class="card">
        <img src="post_img/<%=post.getP_img() %>" class="card-img-top" alt="Placeholder Image">
        <div class="card-body">
          <h5 class="card-title"><%=post.getP_name() %></h5>
          <p class="card-text"><%=post.getP_cntent() %></p>
          <p class="card-text">Date: <%=post.getP_date() %></p>
          <p class="card-text">Category: <%=post.getCat_name() %></p>
          <p class="card-text">Author: John Doe</p>
          
          <!-- Buttons: Like, Read More, Comment -->
          <div class="d-flex justify-content-between align-items-center mt-3">
            <div>
              <!-- Like Button -->
              <button class="btn btn-outline-primary like-btn" onclick="doLike(<%=post.getP_id()%>, <%=u.getUdi()%>)">
                <i class="fa fa-thumbs-up" style="font-size:24px;"></i> Like
              </button>
              <span class="like-count ml-2"><%=l%></span>
            </div>
            
            <!-- Read More Link (Centered) -->
            <div>
              <a href="#" class="btn btn-primary">Read More</a>
            </div>
            
            <div>
              <!-- Comment Button -->
              <button class="btn btn-outline-secondary comment-btn">
                <i class='far fa-comment' style='font-size:24px'></i> Comment
              </button>
              <!-- Include comment count here -->
              <span class="comment-count ml-2">0</span>
            </div>
          </div>
        </div>
      </div>
    </div>
    <% } %>
  </div>
</div>
























	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>

<!--Like-->		
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
  function doLike(pid, uid) {
    $.ajax({
      url: "Liked", // URL mapped to the LikedServlet
      type: 'GET',
      data: {
        pid: pid,
        uid: uid,
        operation: 'like'
      },
      success: function(data, textStatus, jqXHR) {
          console.log(data);
          
          if (data.trim() == 'true') {
            let c=$('.like-count').html();
            c++;
            $('.like-count').html(c);
          }
        },
      error: function(jqXHR, textStatus, errorThrown) {
        console.error("Error:", errorThrown); // Log any error
        // Handle error, for example, show an error message
      }
    });
  }
</script>		
		
		
		
		<!-- POST  -->
		
		
		<script>
  $(document).ready(function() {
    let status = false;
    let btn = document.getElementById("btn");

    // Button click event handling
    btn.addEventListener('click', function() {
      if (status == false) {
        document.getElementById("profile").style.display = "none";
        document.getElementById("edit").style.display = "block";
        btn.innerHTML= "Back";
        status = true;
      } else {
        document.getElementById("profile").style.display = "block";
        document.getElementById("edit").style.display = "none";
        status = false;
        btn.innerHTML= "Update";
      }
    });

  // Form submission using AJAX
    $('#blog').on('submit', function(event) {
      event.preventDefault();
     
      let form = new FormData(this);
      $.ajax({
        url: "addpost",
        type: 'POST',
        data: form,
        processData: false,
        contentType: false,
        success: function(data, textStatus, jqXHR) {
        	swal("Good job!", "Your Post Has Been Submitted!", "success");
        },
        error: function(jqXHR, textStatus, errorThrown) {
          // Handle error
        	swal("Ops!", "Not Posted!", "danger");
        }
      });
    });  
  }); 
</script>
		
		
</body>
</html>
