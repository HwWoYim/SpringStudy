$(function(){
	$('#kakaoB').click(function(){
		$.ajax({
			url:'http://localhost:8088',
			dataType: 'json',
			success:function(data){
				var box = data.next_redirect_pc_url;
				window.open(box)
				},
				error:function(error){
					alert(error);
				}
			});
		});
	});