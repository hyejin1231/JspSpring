<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	// 페이징 관련 변수들
	int writePages = 5;
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>REST+AJAX게시판</title>
<!-- 스타일, js 라이브러리 -->
<!-- TODO -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="<%= request.getContextPath() %>/CSS/rest.css" rel="stylesheet" type="text/css">
</head>
<script>
	$(function() {
		alert("페이지 로딩 후 실행!!");
		
		$("input#page").val(1); // 페이지 최초 로딩하면 1 페이지 기본 
		loadPage(1);
		
		$("button#prev").click(function() {
// 			alert("이전");
			var curPage = parseInt($("input#page").val()); // 현재 페이지 정보 
			if(curPage == 1) {
				alert("이전 페이지가 없습니다.");
				return;
			}
			loadPage(curPage-1);
		});

		$("button#next").click(function() {
			//alert("다음");
			var curPage = parseInt($("input#page").val());
			loadPage(curPage + 1);
		});
	});
	
	function loadPage(page){
		$.ajax({
			url:"${pageContext.request.contextPath }/BoardAJAX/list.do/<%= writePages %>/" + page,
			type : "GET",
			cache : false,
			success : function(data, status) {
				if(status == "success"){
					// updateList(data);

					if(updateList(data)) {
						$("input#page").val(page);
					}
				}
			}
		});
	}

	function updateList(jsonObj) {
		$("table#list tbody").html("");
		result = "";
		//console.log(jsonObj.list);
		
		if(jsonObj.status == "OK") {
			console.log(jsonObj.list);
			$.each(jsonObj.list, function(idx, item) {
				$('<tr>')
				.append($('<td>').html('<input type = checkbox name = wr_uid  value = ' +item.wr_uid + '>'))
				.append($('<td>').html(item.wr_uid))
				.append($('<td>').html(item.subject))
				.append($('<td>').html(item.name))	
				.append($('<td>').html(item.viewcnt))
				.append($('<td>').html(item.regdate))
				.appendTo($('table#list tbody'));
				return true;
			})

			//$("table#list tbody").html(result);	
		}else{
			alert("내용이 없습니다.");
			return false;
		}
		return true;
	}
	
	function chkSubmit() {
		$.ajax({
			url : "${pageContext.request.contextPath }/BoardAJAX//writeOk.do",
			type : "POST",
			cache : false,
			data : {
				"name" : $("#name").val().trim(),
				"subject" : $("#subject").val().trim(),
				"content" : $("#content").val().trim()
			},
			success : function(data, status) {
				if(status == "success") {
					//alert("insert 성공 " + data.count + ":" + data.status);
					loadPage(1);
					$("#name").val("");
					$("#subject").val("");
					$("#content").val("");
					
				}
			}
		});
		
		return false;
	}

	function chkDelete() {
 		//alert($("#frmDelete input[name=wr_uid]").length);
		 var ids = [];
		 $("#frmDelete input[name=wr_uid]").each(function(){
			 if($(this).is(":checked")) {
					ids.push(parseInt($(this).val())); 
			 }
		 });

// 		 alert(ids);

		 if(ids.length == 0 ){
			 alert("삭제할 글을 체크해주세요");
		 } else {
			 if(!confirm(ids.length + "개의 글을 삭제하시겠습니까?")){
				 return false;
			 }

			 $.ajax({
				url : "${pageContext.request.contextPath }/BoardAJAX/deleteOk.do",
				type : "POST",
				data : {
					"wr_uid" : JSON.stringify(ids).slice(1).slice(0,-1)
				},
				cache : false,
				success : function(data, status) {
					if(status == "success") {
						alert("Delete 성공" + data.count + ":" + data.status);
						loadPage(1);
					}
				}
			 });
		 }
		 
		 return false;
	
	}
	

</script>

<body>

<%-- 현재 페이지 (몇 페이지) 정보 --%>
<input type="hidden" id ="page"/>

<form id="frmWrite" onsubmit="return chkSubmit()">
<table>
	<tr>
		<th>name</th>
		<td><input type="text" id="name" placeholder="작성자이름" required/></td>
		<td rowspan="3"><input type="submit" value="새글등록"/></td>
	</tr>
	<tr>
		<th>subject</th>
		<td><input type="text" id="subject" placeholder="글제목" required/></td>
	</tr>
	<tr>
		<th>content</th>
		<td><input type="text" id="content" placeholder="내용입력"/></td>
	</tr>
</table>
</form>
<br>
<form name="frmDelete" id="frmDelete" onsubmit="return chkDelete()">
<table id="list">
	<thead>
		<th>#</th>
		<th>id</th>
		<th>subject</th>
		<th>name</th>
		<th>viewCnt</th>
		<th>regDAte</th>
	</thead>
	<tbody>
	
	</tbody>
</table>
<br>
<input type="submit" value="선택삭제"/>
<button type="button" id="prev">이전페이지</button>
<button type="button" id="next">다음페이지</button>
</form>

</body>
</html>




















