class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small = new PriorityQueue<>((a,b) -> (b-a));
        large  = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.offer(num);
        if(small.size() - large.size() > 1 || !large.isEmpty() && small.peek() > large.peek()){
            int temp = small.poll();
            large.offer(temp);
        }
        if(large.size() - small.size() > 1){
            int temp = large.poll();
            small.offer(temp);
        }
    }
    
    public double findMedian() {
        if(large.size() == small.size()){
            return (large.peek()+small.peek())/2.0;
        }
        if(large.size() > small.size()){
            return (double)large.peek();
        }
        return (double)(small.peek());
    }
}
