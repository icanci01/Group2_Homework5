package hw5;
/*
A class that represents the actual foukou
@author Group2(Canciu Ionut - Cristian, George Christoforou, Panikos Christou)
 * @version 1.0
 * @see https://piazza-resources.s3.amazonaws.com/jqntyc7qdj77hk/ju2alvgoihp443/HW5Spring19.pdf?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=ASIAR6AWVCBXVMJ5WK5O%2F20190416%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20190416T154431Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Security-Token=AgoJb3JpZ2luX2VjEDsaCXVzLWVhc3QtMSJHMEUCIQD%2Fjzdz9HQiKU9wUZF81h9P%2BF9WNCwYOJdA9dWtMUzWFwIgUHlySvjdO4isf8kMGtyYCp5ejt5pU64gcHSLJN4IQJ8q2gMIFBAAGgwxMzMxOTE1MDM5ODMiDGdEwQnRp%2FA20oul8Cq3A%2BE7Ir229Pu9Qo2oDZCMFLPldeYMaPXWEcVJPNRNVJpbkC70kLAjqMh2e%2F22ORg3KvU5iyIs0cVMlgFYuW2e%2FcIcyFxGMhiZRgB7uq5oO0g6cql2EvMLeeU78PmgjMdyEYhwGNQ6mZSuwTmRmwVCXVfX2pbA7CDz1%2FwMPjghVHBJ46IpRt3Q7Uf2ylmmNN1wtgzGzVbtaEngD3ynhf9wXM0VtdfZWgViYRkVw%2FAsBEEE%2FJ4hbN5J03H0DmlB%2BnYv7C3VO%2BTA0wz1eqjgmle4YcECFN49UdOyZO1wjVVCgm7IJ1dDRPz%2BUAa2RmVOeu%2BEfA5CQ8OQ2EHHNKnngps9OgRl4F79y1crgLRXjjRetMszjqDipv%2BfDeOITpsTTpcLCLXB4Wyh3XAJFbusooE2H%2BSqCTI3KCGbs53k5S9ht%2BgjSWq7YbqM3pOxnvThDrEBJ4ee%2BS38yNlt8QoQYLGzAXLfwvOOjKof0Nc02hxUbVhaZyEIIJ5QqcxknmVKzm%2BPE1%2BvPZVZdfxpN9nrDFGG8LSYY6%2BmeEbbiOchNkyB8U%2B3jqXrgGum7VdsJOSYHM4jvpawQVBxOCww%2FOTW5QU6tAHpfqe%2B7EbdsFUA%2B%2FkimEcU6oTTveojQ1iesad146zeXXaTP3TAVxwH2fAoYEASk%2Fnu2gh2%2Fck2aR3%2BekxdQ8qzbn9gapRgWjXssyvIrYRz5kafwBe3U3gf5kS%2BY0LPO%2BGtqcbM8Slj8fKgi28ADXEhvjHzqtNPXHjx7BjkVjaFOAUQCra31dvV1Fl4MJ%2BcWjXdxpAd0zhrWO9ML8cLz3%2FC1AA%2Bn5momOTh1bhMjmdHtn%2FzTuI%3D&X-Amz-Signature=739432a410675654bcc35edcc10c9a8b5225f0c2fffb76fddf35a31502cbf85a
 * @since 16/04/19
 */
import hw5.menu.Smiles.Ingedients;

import java.util.ArrayList;

public class Foukou {

    public static int counter = -30; //the time that the souvlajidiko is open
    private int capacity;
    private int usedSpace;
    private ArrayList<Ingedients> foukou;

    /*
    Constructor of foukkou
     */
    public Foukou(int capacity) {
        this.capacity = capacity;
        this.usedSpace = 0;
        foukou = new ArrayList<Ingedients>(capacity); //an aaray list to help us add and remove ingredients tou foukou easily
    }

    /*
    Calculates the time that an order needs to cook on the foukou
     */
    public static int timeCaclculator(Order order, Foukou foukou) {
        int maxTime = 0;
        for (int j = 0; j < order.getPites().length; j++) {
            foukou.add(order.getPites()[j].getA());
            order.getPites()[j].getA().psise();
            foukou.add(order.getPites()[j].getB());
            order.getPites()[j].getB().psise();
            foukou.add(order.getPites()[j].getP());
            order.getPites()[j].getP().psise();
            int tempMax = Math.max(order.getPites()[j].getA().psise(), order.getPites()[j].getB().psise());
            if (maxTime < tempMax)
                maxTime = tempMax;
        }
        return maxTime;

    }

    /*
    Adds ingredients to the arraylist of foukou
     */
    public void add(Ingedients item) {
        if (this.isFull())
            System.out.println("Foukou is full");
        else {
            foukou.add(item);
            usedSpace = usedSpace + item.getSize();
        }
    }

    /*
    Bakes the ingredients
     */
    public int psise(Ingedients item) {
        return item.psise();
    }

    /*
    Removes ingredients from the foukou
     */
    public void remove(Ingedients item) {
        usedSpace = usedSpace - item.getSize();
        foukou.remove(item);
    }

    /*
    Returns the capacity of foukou
     */
    public int getCapacity() {
        return capacity;
    }

    /*
    Return the used space on foukou
     */
    public int getUsedSpace() {
        return usedSpace;
    }

    /*
    Checks if the foukou is Empty
     */
    public boolean isEmpty() {
        return this.usedSpace == 0;
    }

    /*
    Manage the ingredients on the foukou
     */
    public static int foukouDistribution(Order order, Foukou foukou) {
        int maxTime = 0;

        for (int i = 0; i < order.getPites().length; i++) {//add the ingredients and bake them
            if (!foukou.isFull()) {
                foukou.add(order.getPites()[i].getA());
                order.getPites()[i].getA().psise();
                foukou.add(order.getPites()[i].getB());
                order.getPites()[i].getB().psise();
                foukou.add(order.getPites()[i].getP());
                order.getPites()[i].getP().psise();
                int tempMax = Math.max(order.getPites()[i].getA().psise(), order.getPites()[i].getB().psise());
                if (maxTime < tempMax)
                    maxTime = tempMax;
            } else {
                counter += maxTime;//maxTime is the time that an order is needed to bake
                for (int j = 0; j < order.getPites().length; j++) {
                    if (order.getPites()[j].getA().done)
                        foukou.remove(order.getPites()[j].getA());
                    if (order.getPites()[j].getP().done)
                        foukou.remove(order.getPites()[j].getB());
                    if (order.getPites()[j].getP().done)
                        foukou.remove(order.getPites()[j].getP());
                    for (int k = i; k < order.getPites().length; k++) {
                        foukou.add(order.getPites()[k].getA());
                        order.getPites()[i].getA().psise();
                        foukou.add(order.getPites()[k].getB());
                        order.getPites()[i].getB().psise();
                        foukou.add(order.getPites()[k].getP());
                        order.getPites()[i].getP().psise();
                        int tempMax = Math.max(order.getPites()[i].getA().psise(), order.getPites()[i].getB().psise());
                        if (maxTime < tempMax)
                            maxTime = tempMax;
                    }
                }
            }
        }

        counter += maxTime;
        for (int i = 0; i < order.getPites().length; i++) {//remove the ingredients from foukou
            foukou.remove(order.getPites()[i].getA());
            foukou.remove(order.getPites()[i].getB());
            foukou.remove(order.getPites()[i].getP());
        }

        if (counter > 360)
            return 361;
        return counter;
    }

    /*
    Return the space left on foukou
     */
    public int getLeftSpace() {
        return capacity - usedSpace;
    }

    /*
    Checks if the foukou is full
     */
    public boolean isFull() {
        return this.usedSpace == this.capacity;
    }

}
