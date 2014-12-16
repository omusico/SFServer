package com.miaoyou.platform.server.utils;

public class Pager {
		
    private int startDataIndex;
	
    private int pageSize;
        
    private int count;
    
    private int pageindex;
    
    public Pager(int startDataIndex,int pagesize){
        this.pageSize = pagesize;
        startDataIndex = startDataIndex<0?0:startDataIndex;
        this.startDataIndex=startDataIndex;
        
        this.pageindex = startDataIndex%pagesize;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the startDataIndex
     */
    public int getStartDataIndex() {
        if(getCount()<=0){
            return startDataIndex;
        }
        if((startDataIndex)>getCount()){
          startDataIndex = getCount()-getPageSize();
          if(startDataIndex<0)startDataIndex=0;
        }
        return startDataIndex;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }
    
    public int getPageindex(){
     return pageindex;
    }


}
