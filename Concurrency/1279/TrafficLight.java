class TrafficLight {
    private ReentrantLock trafficLock = new ReentrantLock();;
    private boolean road1Green = true; // 道路1亮绿灯;
    private boolean road2Green = false; // 道路2亮红灯;

    public TrafficLight() {

    }

    public void carArrived(
        int carId,           // ID of the car
        int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
        int direction,       // Direction of the car
        Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
        Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        trafficLock.lock();
        try {
            if (roadId == 1 && road1Green == true || roadId == 2 && road2Green == true) {
                crossCar.run();
            } else if (roadId == 1) {
                turnGreen.run();
                road1Green = true;
                road2Green = false;
                crossCar.run();
            } else if (roadId == 2) {
                turnGreen.run();
                road1Green = false;
                road2Green = true;
                crossCar.run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            trafficLock.unlock();
        }
    }
}
