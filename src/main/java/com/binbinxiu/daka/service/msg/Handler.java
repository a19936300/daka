package com.binbinxiu.daka.service.msg;

public abstract class Handler<T> {
    private Handler<T> next = null;

    public void setNext(Handler<T> next){
        this.next = next;
    }
    
    public void requestHandler(T msg){
        if(!canRequest(msg)){
            if(this.next != null){
                this.next.requestHandler(msg);
            }
        }
    }

    
    public abstract boolean canRequest(T msg);

}
