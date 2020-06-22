package javaSE.collections.own.hashMap;

public class OwnHashMap {

    private Node[] nodes;
    private int size;

    public OwnHashMap(int basicSize)
    {
        nodes = new Node[basicSize];
    }

    public boolean put(int key, long value)
    {
        Node newNode = new Node(key, value);
        int index = index(newNode);

        if(nodes[index] != null)
        {
            return collisionProcessing(index, newNode);
        } else {
            simpleInput(index, newNode);
            return true;
        }
    }

    public long get(int key)
    {
        Node node = new Node(key, 0);
        int index = index(node);

        for(int i = 0; i < nodes.length; i++)
        {
            if((index + i) == (nodes.length -1) ) return 0;

            if(nodes[index + i] != null)
            {
                if(node.hash() == nodes[index+i].hash() && node.key == nodes[index+i].key) {
                    return nodes[index + i].value;
                }
            } else {
                return 0;
            }
        }
        return 0;
    }

    public long[] getAllValues()
    {
        long[] resultArray = new long[nodes.length];

        for(int i = 0; i < nodes.length; i++)
        {
            resultArray[i] = nodes[i].getValue();
        }

        return resultArray;
    }

    /**WARNING! test method*/
    public void showFullMap()
    {
        for(int i = 0 ; i < nodes.length; i++)
        {
            if(nodes[i] == null)
            {
                System.out.println("null");
            } else {
                System.out.println(nodes[i].toString());
            }
        }
    }


    private int index(Node node){
        return node.hash() % nodes.length;
    }

    private boolean collisionProcessing(int index, Node node)
    {

        for(int i = 0; i < nodes.length; i++){

            if((index + i) > (nodes.length -1))
            {
                System.err.println("WARNING! No free space for this key!");
                return false;
            }
            if(nodes[index+i] != null)
            {
                if(node.hash() == nodes[index+i].hash() & node.equals(nodes[index+i])) {
                    simpleInput(index + i, node);
                    return true;
                }
            } else {
                simpleInput(index + i, node);
                return true;
            }
        }

        return false;
    }

    private void simpleInput(int index, Node node)
    {
        this.nodes[index] = node;
        this.size++;
    }

    public int getSize() {
        return size;
    }

    public int getNodesSize()
    {
        return nodes.length;
    }

    private class Node {
        private int key;
        private long value;

        Node (int input_key, long input_value)
        {
            key = input_key;
            value = input_value;
        }

        int hash()
        {
            int hash = 17 + this.key * 31;
            return hash < 0 ? hash * -1 : hash;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;

            return this.key == node.key & this.value == node.value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public long getValue() {
            return value;
        }

        public void setValue(long value) {
            this.value = value;
        }
    }

}
