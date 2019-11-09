<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 통계 확인</title>
<%@ include file="../include/header.jsp" %>
<script src="../include/jquery-3.3.1.min.js"></script>
<link href="../css/list_style.css" rel="stylesheet">
</head>
<body>
<table id="search" style="border:1px solid black; border-collapse:collapse; margin:0 auto;">
	<tr>
		<td rowspan="2">
			<select name="arg_area_cd" id="arg_area_cd">
				<option value="">전체</option>
				<option value="10">서울</option>
				<option value="20">경기</option>
				<option value="30">인천</option>
				<option value="40">평택</option>
				<option value="50">울산</option>
				<option value="60">대전</option>
				<option value="70">부산</option>
				<option value="80">광주</option>
				<option value="90">제주</option>
				<option value="95">파주</option>
			</select>
		</td>
		<td>
			<input type="radio" name="arg_gr" value="" checked>전체
			<input type="radio" name="arg_gr" value="00">DATA
			<input type="radio" name="arg_gr" value="01">중간총계
			<input type="radio" name="arg_gr" value="11">총계			
		</td>
		<td>
			<input type="radio" name="arg_dir" value="F" checked>DATA 우선
			<input type="radio" name="arg_dir" value="R">총계 우선
		</td>
		<td rowspan="2">
			<button id="btnSearch">검색</button>
		</td>
	</tr>
	<tr>
		<td>
			서울<input type="number" class="cd_nm" min="1" max="10" name="arg_rk1" id="arg_rk1">
			경기<input type="number" class="cd_nm" min="1" max="10" name="arg_rk2" id="arg_rk2">
			인천<input type="number" class="cd_nm" min="1" max="10" name="arg_rk3" id="arg_rk3">
			평택<input type="number" class="cd_nm" min="1" max="10" name="arg_rk4" id="arg_rk4">
			울산<input type="number" class="cd_nm" min="1" max="10" name="arg_rk5" id="arg_rk5"><br>
			대전<input type="number" class="cd_nm" min="1" max="10" name="arg_rk6" id="arg_rk6">
			부산<input type="number" class="cd_nm" min="1" max="10" name="arg_rk7" id="arg_rk7">
			광주<input type="number" class="cd_nm" min="1" max="10" name="arg_rk8" id="arg_rk8">
			제주<input type="number" class="cd_nm" min="1" max="10" name="arg_rk9" id="arg_rk9">
			파주<input type="number" class="cd_nm" min="1" max="10" name="arg_rk10" id="arg_rk10">
		</td>
		<td style="vertical-align:middle;">
			건수&nbsp;<input name="arg_rn" id="arg_rn">
		</td>
	</tr>
</table>
<br>
<div id="div1"></div>
<br>
<table id="table">
	<thead>
		<tr style="background-color:#ccc;">
			<th>지역</th>
			<th>국가</th>
			<th>청소기</th>
			<th>세탁기</th>
			<th>건조기</th>
			<th>정수기</th>
			<th>도어락</th>
			<th>전화기</th>
			<th>냉장고</th>
			<th>김치냉장고</th>
			<th>전자레인지</th>
			<th>가스레인지</th>
			<th>합계</th>
		</tr>
	</thead>
	<tbody id="tbody"></tbody>
</table>

<script>
$(function(){
	list();
	$("#btnSearch").click(function(){
		list();
	});
});
function list(){
	var param=/* $("#form1").serialize(); */
		  "arg_rn="+$("#arg_rn").val()+"&arg_area_cd="+$("#arg_area_cd").val()
			+"&arg_gr="+$(":radio[name='arg_gr']:checked").val()+"&arg_rk1="+$("#arg_rk1").val()
			+"&arg_rk2="+$("#arg_rk2").val()+"&arg_rk3="+$("#arg_rk3").val()
			+"&arg_rk4="+$("#arg_rk4").val()+"&arg_rk5="+$("#arg_rk5").val()
			+"&arg_rk6="+$("#arg_rk6").val()+"&arg_rk7="+$("#arg_rk7").val()
			+"&arg_rk8="+$("#arg_rk8").val()+"&arg_rk9="+$("#arg_rk9").val()
			+"&arg_rk10="+$("#arg_rk10").val()
			+"&arg_dir="+$(":radio[name='arg_dir']:checked").val(); 
	$("#div1").empty();
	$("#tbody").empty();
	$.ajax({
		type: "GET",
		url: "${path}/sale/ajax_list",
		data: param,
		contentType: "application/json; charset=utf-8",
		success: function(map){
			//console.log(result);
			//$("#result").html(result);			
			console.log(map.time);
			console.log(map.list);			
			$('<span>').append("실행 시간: "+map.time+" sec").appendTo("#div1");
			$("#div1").css('font-weight','600').css('color','black').css('text-align','center');
			$.each(map.list, function(idx,item){
				$('<tr>')
				.append($('<td>').html(item.cd_nm))
				.append($('<td>').html(item.region_area))
				.append($('<td>').html(item.c00))
				.append($('<td>').html(item.c01))
				.append($('<td>').html(item.c02))
				.append($('<td>').html(item.c03))
				.append($('<td>').html(item.c04))
				.append($('<td>').html(item.c05))
				.append($('<td>').html(item.c06))
				.append($('<td>').html(item.c07))
				.append($('<td>').html(item.c08))
				.append($('<td>').html(item.c09))
				.append($('<td>').html(item.tot).css('font-weight','600').css('text-align','right'))
				.appendTo("#tbody");
				$("#tbody > tr").css('background','#f2f2f2');
				$("td:contains('▲')").css('color','red').css('font-weight','600');
				$("td:contains('▼')").css('color','blue').css('font-weight','600');
				$("#tbody > tr:contains('합계')").css('background','#b3ff99');
				$("#tbody > tr:contains('총계')").css('background','#b3cce6').css('font-weight','600');
			});
		}
	});
}
</script>
</body>
</html>