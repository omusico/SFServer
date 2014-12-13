package com.miaoyou.platform.server.utils;

public class Pager {
		
    private int startDataIndex;
	
    private int pageSize;
        
    private int count;
    
    private int pageindex;
    
    public Pager(int pageindex,int pagesize){
        this.pageSize = pagesize;
        pageindex=pageindex<=0?1:pageindex;
        startDataIndex=(pageindex - 1) * pagesize;
        this.pageindex = pageindex;
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
