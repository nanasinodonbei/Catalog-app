package test.example.catalog.commons;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * リクエストの空白文字をnullに変換する
 */

@ControllerAdvice
public class CommonAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(java.lang.String.class, new StringTrimmerEditor(true));
    }
}
