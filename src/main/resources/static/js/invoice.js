
$('document').ready(function(){
    $('.editButton').on('click', function(event){
        event.preventDefault();	

        var href = $(this).attr('href')
        $.get(href, function(invoice, status){
            $('#idEdit').val(invoice.id)
            $('#ddlClientEdit').val(invoice.clientid);
            $('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateEdit').val(invoiceDate);
            $('#remarksEdit').val(invoice.remarks);
        })

        $('#editModal').modal()
    });

    $('.detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(invoice, status){
			$('#idDetails').val(invoice.id)
            $('#ddlClientDetails').val(invoice.clientid);
            $('#ddlInvoiceStatusDetails').val(invoice.invoicestatusid);
            var invoiceDate = invoice.invoiceDate.substr(0,10);
            $('#invoiceDateDetails').val(invoiceDate);
            $('#remarksDetails').val(invoice.remarks);
			$('#lastModifiedByDetails').val(invoice.lastModifiedBy);
			$('#lastModifiedDateDetails').val(invoice.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	

    $('.deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#delRef').attr('href', href);
		$('#deleteModal').modal();		
	});
});