package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	   	public boolean isValidPhoneNumber(String number) {
	        Pattern pattern = Pattern.compile("^[0-9]*$");
	        Matcher matcher = pattern.matcher(number);
	        if (!matcher.matches()) {
	            return false;
	        } else
	        	if(number.substring(0,1).equals("0"))
	        		return true;
	        	else
	        		return false;
	    }
	   	public boolean isValidId(String number) {
	        Pattern pattern = Pattern.compile("^[0-9]{9}$");
	        Matcher matcher = pattern.matcher(number);
	        if (!matcher.matches()) {
	            return false;
	        } else return true;
	        
	    }
	   	public boolean isValidName(String name) {
	        Pattern pattern = Pattern.compile("^[a-zA-Z_ẾếÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{1,255}+$");
	        Matcher matcher = pattern.matcher(name);
	        if (!matcher.matches()) {
	            return false;
	        } else
	        	return true;
	    }
	   	public boolean isValidAddress(String name) {
	        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_ẾếÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]{1,255}+$");
	        Matcher matcher = pattern.matcher(name);
	        if (!matcher.matches()) {
	            return false;
	        } else
	        	return true;
	    }
}
