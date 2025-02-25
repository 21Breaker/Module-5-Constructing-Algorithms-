class Graph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, u, v):
        if u not in self.graph:
            self.graph[u] = []
        self.graph[u].append(v)

    def dfs(self, start, goal, path=None):
        if path is None:
            path = []
        path.append(start)

        if start == goal:
            return path

        for neighbor in self.graph.get(start, []):
            if neighbor not in path:
                result = self.dfs(neighbor, goal, path.copy())
                if result:
                    return result

        return None

# Example usage:
g = Graph()
g.add_edge('A', 'B')
g.add_edge('A', 'C')
g.add_edge('B', 'D')
g.add_edge('C', 'D')
g.add_edge('D', 'E')

start_building = 'A'
end_building = 'E'
path = g.dfs(start_building, end_building)

if path:
    print(f"Path from {start_building} to {end_building}: {' -> '.join(path)}")
else:
    print(f"No path found from {start_building} to {end_building}")
