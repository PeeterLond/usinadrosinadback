package com.example.usinadrosinadback.util;

import lombok.Getter;

@Getter
public enum EmailTemplates {

    RESET_PASSWORD("Salasõna taastatud Usinate Rosinate leheküljel",
            """
                    Unustasid enda Usinate Rosinate salasõna?
                    
                      Siin on sinu uus salasõna: [salasõna]
                      
                      Aitäh, et kasutad meie platvormi""");


    private final String title;
    private final String message;

    EmailTemplates(String title, String message) {

        this.title = title;
        this.message = message;
    }
}
