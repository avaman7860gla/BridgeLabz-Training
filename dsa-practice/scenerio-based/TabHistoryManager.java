import java.util.List;
import java.util.ArrayList;

interface Navigable{
    public void forward();
    public void backward();
}

class Tab implements Navigable{
    private int tabId;
    private String title;
    private HistoryList history=new HistoryList();
    private HistoryNode current;

    public Tab(int tabId, String title){
        this.tabId=tabId;
        this.title=title;
    }

    public int getTabId(){
        return tabId;
    }

    public void navigate(String url){
        history.addPage(url);
        current=history.getTail();
    }

    public String getCurrentPage(){
        if(current!=null){
            return current.url;
        }
        return null;
    }

    public void forward(){
        if(current!=null && current.next!=null){
            current=current.next;
        }
    }

    public void backward(){
        if(current!=null && current.prev!=null){
            current=current.prev;
        }
    }
}

class HistoryNode{
    String url;
    HistoryNode prev;
    HistoryNode next;

    public HistoryNode(String url){
        this.url=url;
    }
}

class HistoryList{
    private HistoryNode head;
    private HistoryNode tail;

    public HistoryList(){
        this.head=null;
        this.tail=null;
    }

    public void addPage(String url){
        HistoryNode newNode=new HistoryNode(url);
        if(head==null){
            head=newNode;
            tail=newNode;
        }
        else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
    }

    public void removePage(HistoryNode node){
        if(node.prev!=null){
            node.prev.next=node.next;
        }
        else{
            head=node.next;
        }

        if(node.next!=null){
            node.next.prev=node.prev;
        }
        else{
            tail=node.prev;
        }
    }

    public HistoryNode getHead(){
        return head;
    }

    public HistoryNode  getTail(){
        return tail;
    }
}

class Browser{
    private List<Tab> openTabs=new ArrayList<>();
    private TabStack closedTabs=new TabStack();

    public void openTab(String url){
        Tab newTab=new Tab(openTabs.size()+1,"Tab"+(openTabs.size()+1));
        newTab.navigate(url);
        openTabs.add(newTab);
        System.out.println("New tab opened: "+url);
    }

    public void closeTab(int tabId){
        Tab toClose=null; 
        for(Tab tab:openTabs){ 
            if(tab.getTabId()==tabId){ 
                toClose=tab; 
                break; 
            } 
        } 
        if (toClose!=null) { 
            openTabs.remove(toClose); 
            closedTabs.push(toClose); 
            System.out.println("Closed tab: " + tabId); 
        } 
        else { 
            System.out.println("Tab not found: " + tabId); 
        }
    }

    public void restoreTab(){
        if(!closedTabs.isEmpty()){
            Tab restored=closedTabs.pop();
            openTabs.add(restored);
            System.out.println("Restored tab: "+restored.getCurrentPage());
        }
        else{
            System.out.println("No tab to restore");
        }
    }

    public void switchTab(int tabId){
        for(Tab tab:openTabs){ 
            if(tab.getTabId()==tabId){ 
                System.out.println("Switched to tab "+tabId); 
                return; 
            } 
        } 
        System.out.println("Tab not found: "+tabId); 
    }
}

class TabStack{
    private List<Tab> elements=new ArrayList<>();



    public void push(Tab tab){
        elements.add(tab);
    }

    public Tab pop(){
        if(elements.size()!=0){
            return elements.remove(elements.size()-1);
        }
        return null;
    }

    public Tab peek(){
        if(elements.size()!=0){
            return elements.get(elements.size()-1);
        }
        return null;
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }
}


public class TabHistoryManager {
    public static void main(String[] args) {
        Browser browser = new Browser();

      
        browser.openTab("https://example.com");
        browser.openTab("https://github.com");

      
        browser.switchTab(1);
        browser.switchTab(2);

      
        browser.closeTab(2);

        browser.restoreTab();

        Tab tab = new Tab(4, "Tab4");
        tab.navigate("https://google.com");
        tab.navigate("https://stackoverflow.com");
        tab.navigate("https://gla.ac.in");

        System.out.println("Current page in Tab4: " + tab.getCurrentPage());

      
        tab.backward();
        System.out.println("After backward: " + tab.getCurrentPage());

        tab.forward();
        System.out.println("After forward: " + tab.getCurrentPage());
    }
}

