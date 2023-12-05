import java.util.Stack;

public class Graph {
    private final int MAX_VERTEXES = 30;
    private Vertex vertexArray[];
    private int adjacencyMatrix[][];
    private int vertexNumber;
    private Stack<Integer> stack;

    public Graph() {
        vertexArray = new Vertex[MAX_VERTEXES];
        adjacencyMatrix = new int[MAX_VERTEXES][MAX_VERTEXES];
        stack = new Stack<>();
    }

    public void addVertex(char label){
        vertexArray[vertexNumber++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjacencyMatrix[start][end] = 1;
        adjacencyMatrix[end][start] = 1;
    }
    public void displayVertex(int v){
        System.out.println(vertexArray[v].label);
    }

    public void dfs() // Обход в глубину
    {
        processVertex(0); //  начинаем с вершины 0

        while (!stack.empty()){
            int v = getUnvisitedAdjVertex(stack.peek());
            if(v == -1){
                stack.pop();
            } else {
                processVertex(v);
            }
        }
    }

    private int getUnvisitedAdjVertex(int v){
        for(int i = 0; i < vertexNumber; i++){
            if(adjacencyMatrix[v][i] == 1 && !vertexArray[i].wasVisited)
                return i;
        }
        return -1;
    }

    private void processVertex(int v){
        vertexArray[v].wasVisited = true;
        displayVertex(v);
        stack.push(v);
    }
}
