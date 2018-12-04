$(document).ready(function() {

	$('#inputform').on('submit', function(event) {
		$( "#maintarget" ).hide(200);
		$("#loadingScreen").modal("show");
		$.ajax({
			data : {
				qry : $('#qry').val()
			},
			type : 'POST',
			url : '/query'
		})
		.done(function(data) {
				$("#loadingScreen").modal("hide");
				
				$( "#maintarget" ).show(200);
				if(data.code == 202){
					$( "#maintarget" ).html("<b>"+data.msg+"</b></br>");
				}else if(data.code == 405){
					$( "#maintarget" ).html("<b>Key already exist.</b></br>");
				}else if(data.code == 404){
					$( "#maintarget" ).html("<b>Columns mismatch | Insufficient entry error.</b></br>");
				}else if(data.code == 406){
					$( "#maintarget" ).html("<b>Invalid input | Referenced key does not exist.</b></br>");
				}else if(data.code == 407){
					$( "#maintarget" ).html("<b>Syntax | Ambiguous error.</b></br>");
				}else if(data.code == 408){
					$( "#maintarget" ).html("<b>Table not found.</b></br>");
				}else if(data.code == 200){

					content = '';
					thead = '';

					data.headers.forEach(function(val) {
							thead =thead+'<th>'+val.toUpperCase()+'</th>';
						});
					thead = '<thead><tr>'+thead+'</thead></tr>';

					//formatedTable ='<div style="max-height:500px;overflow:auto;"><table class="table table-hover" >'+thead+'<tbody id="tblContent" name="tblContent"></tbody></table></div>';
					formatedTable ='<div style="max-height:500px;overflow-x:auto;"><table id="resultTable" class="table table-hover display" >'+thead+'<tbody id="tblContent" name="tblContent"></tbody></table></div>';

					$( "#maintarget" ).html(formatedTable);

	
					$.each(data.tbl[0], function(key, val) {
								tbbodymid = '';
								val.forEach(function(colval) {
									tbbodymid =tbbodymid+'<td name='+key+' id='+key+'>'+colval+'</td>';
								});
							$( "#tblContent" ).append( '<tr>'+tbbodymid+'</tr>' );
						});

						$('#resultTable').DataTable( {
							"pagingType": "simple_numbers"
					} );
				
						
						
				}else{
					$( "#maintarget" ).html("<b>Undefined error.</></br>");
				}

			if(data.code == 200){
				$( "#qtime" ).html("Time elapsed: "+data.qtime+" seconds"+"<br>Results : "+data.resultCount);
			}else{
				$( "#qtime" ).html("Time elapsed: "+data.qtime+" seconds");
			}


		});
		event.preventDefault();
	});


	$( "#student" ).click(function() {
		$( "#schematarget" ).html("STUDENT<br>{<br>StudNo char,<br>StudentName char,<br>Birthday char,<br>Degree char,<br>Major char,<br>UnitsEarned int<br>}");
	  });
	$( "#studenthistory" ).click(function() {
		$( "#schematarget" ).html("STUDENTHISTORY<br>{<br>StudNo char,<br>Description char,<br>Action char,<br>DateFiled char,<br>DateResolved char<br>}");
	  });
	$( "#studcourse" ).click(function() {
		$( "#schematarget" ).html("STUDCOURSE<br>{<br>StudNo char,<br>CNo char,<br>Semester char,<br>AcadYear char<br>}");
	  });
	$( "#course" ).click(function() {
		$( "#schematarget" ).html("COURSE<br>{<br>CNo char,<br>CTitle char,<br>CDesc char,<br>NoOfUnites int,<br>HasLab int,<br>SemOffered char<br>}");
	  });
	$( "#courseoffering" ).click(function() {
		$( "#schematarget" ).html("COURSEOFFERING<br>{<br>Semester char,<br>AcadYear char,<br>CNo char,<br>Section char,<br>Time char,<br>MaxStud int<br>}");
	  });
});