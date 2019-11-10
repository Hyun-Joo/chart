/**
 * 
 */
$(function(){
	list();
	$("#btnSearch").click(function(){
		list();
	});
});
function list(){
	var param = "arg_rn="+$("#arg_rn").val()+"&arg_area_cd="+$("#arg_area_cd").val()
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
		async: true,
		type: "GET",
		url: "/chart/sale/ajax_list",
		data: param,
		contentType: "application/json; charset=utf-8",
		success: function(map){
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