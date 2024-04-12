function solution(info, edges) {
  var answer = 0;


  const nodeCnt = info.length;
  const graph = Array.from({ length: nodeCnt }, () => []);

  for (let [a, b] of edges) {
    graph[a].push(b);
  }

  let maxSheepCnt = -1;

  const dfs = (x, sheepCnt, wolfCnt, visited) => {
    if (sheepCnt <= wolfCnt) return;
    maxSheepCnt = maxSheepCnt > sheepCnt ? maxSheepCnt : sheepCnt;

    for (let i = 0; i < graph[x].length; i++) {
      const nx = graph[x][i];
      visited = visited | (1 << nx);
    }

    for (let i = 0; i < nodeCnt; i++) {
      if ((visited & (1 << i)) === 0) continue;

      visited = visited ^ (1 << i);

      if (info[i] === 1) {
        dfs(i, sheepCnt, wolfCnt + 1, visited);
      } else if (info[i] === 0) {
        dfs(i, sheepCnt + 1, wolfCnt, visited);
      }
      visited = visited ^ (1 << i);
    }
  };

  dfs(0, 1, 0, 0);

  answer = maxSheepCnt;
  return answer;
}