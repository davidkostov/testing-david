package com.clouway.mocks;

/**
 * @author David Kostov (david.kostov.cw@gmail.com)
 */
public class StartsWithKeyword implements Endpoint{
    private String keyword;

    public StartsWithKeyword(String keyword){
        this.keyword = keyword;
    }

    public boolean matches(String url) {
        return url.startsWith(keyword);
    }
}
