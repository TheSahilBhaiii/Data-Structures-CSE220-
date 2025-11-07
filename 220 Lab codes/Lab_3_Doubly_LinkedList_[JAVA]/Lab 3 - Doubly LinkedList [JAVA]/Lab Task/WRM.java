// NO NEED THIS SUBMIT THIS CLASS
public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    public void registerPatient(int id, String name, int age, String bloodgroup) {
        Patient newP=new Patient(id,name,age,bloodgroup,null,null);
        Patient before=dh.prev;
        Patient after=dh;

        newP.next=after;
        newP.prev=before;
        before.next=newP;
        after.prev=newP;

    }

    public void servePatient(){
     Patient t=dh.next;
     dh.next=t.next;
     t.next.prev=dh;
     t.prev=t.next=null;
    }

    public void showAllPatient() {
        Patient head=dh.next;

        while(head!=dh){
            System.out.println(head.id);
            head=head.next;
        }
    }

    public Boolean canDoctorGoHome() {
        if(dh.next==dh &&dh.prev==dh){
        return true;
        }
        return false;
    }

    public void cancelAll() {
        dh.next=dh;
        dh.prev=dh;
    }


    public void reverseTheLine() {
        Patient t=dh.next;

        while(true){
            Patient temp=t.next;
            t.next=t.prev;
            t.prev=temp;
            t=t.prev;
        }
        if(t.prev==dh){
            break;
        }
    }

}
