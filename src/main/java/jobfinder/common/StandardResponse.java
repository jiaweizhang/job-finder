package jobfinder.common;

/**
 * Created by jiaweizhang on 2/29/2016.
 */

public class StandardResponse {
    private Boolean error;
    private String message;
    private Object data;

    public StandardResponse(Boolean error, String message, Object data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public StandardResponse(Boolean error, String message) {
        this.error = error;
        this.message = message;
        this.data = null;
    }

    public Boolean getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
