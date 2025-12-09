package pojos;

public class HerokuAppPostResponsePojo {

    private Integer bookingid;
    private HerokuAppResponsePojo booking;

    public HerokuAppPostResponsePojo() {
    }

    public HerokuAppPostResponsePojo(Integer bookingid, HerokuAppResponsePojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public HerokuAppResponsePojo getBooking() {
        return booking;
    }

    public void setBooking(HerokuAppResponsePojo booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "HerokuAppPostResponsePojo{" +
                "bookingid=" + bookingid +
                ", booking=" + booking +
                '}';
    }
}