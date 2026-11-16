<script setup>
import { ref } from 'vue'

const activeTab = ref('avl')

const snippets = {
  avl: {
    title: 'AVLTree.java',
    badge: 'O(log N) Self-Balancing',
    code: `// Strict Balance Factor Invariant: balance ∈ {-1, 0, 1}
private Node balance(Node node) {
    updateHeight(node);
    int factor = getBalance(node);

    // Left-Left & Left-Right Rotations
    if (factor > 1) {
        if (getBalance(node.left) < 0) node.left = rotateLeft(node.left);
        return rotateRight(node);
    }
    // Right-Right & Right-Left Rotations
    if (factor < -1) {
        if (getBalance(node.right) > 0) node.right = rotateRight(node.right);
        return rotateLeft(node);
    }
    return node;
}`
  },
  lfu: {
    title: 'LFUCache.java',
    badge: 'O(1) Constant Time Eviction',
    code: `// O(1) Eviction: frequency buckets + linked tie-breakers
public void put(int key, int value) {
    if (capacity <= 0) return;
    if (cache.containsKey(key)) {
        cache.get(key).val = value;
        get(key); // bump frequency
        return;
    }
    if (cache.size() >= capacity) {
        int evictKey = freqMap.get(minFreq).iterator().next();
        freqMap.get(minFreq).remove(evictKey);
        cache.remove(evictKey);
    }
    // Seed new node at frequency = 1
    minFreq = 1;
    cache.put(key, new Node(key, value, 1));
    freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
}`
  },
  tarjan: {
    title: 'TarjanGraphAlgorithms.java',
    badge: 'O(V + E) Linear Bridges',
    code: `// Tarjan DFS: low-link values detect articulation bridges
private void dfsBridge(int u, int parent) {
    discovery[u] = low[u] = ++time;
    for (int v : adj.get(u)) {
        if (v == parent) continue;
        if (discovery[v] != -1) {
            low[u] = Math.min(low[u], discovery[v]);
        } else {
            dfsBridge(v, u);
            low[u] = Math.min(low[u], low[v]);
            if (low[v] > discovery[u]) {
                bridges.add(new Edge(u, v)); // Bridge invariant
            }
        }
    }
}`
  }
}
</script>

<template>
  <div class="code-showcase-container">
    <div class="showcase-header">
      <div class="traffic-lights">
        <span class="light red"></span>
        <span class="light yellow"></span>
        <span class="light green"></span>
      </div>
      <div class="tab-list">
        <button 
          :class="['tab-btn', { active: activeTab === 'avl' }]" 
          @click="activeTab = 'avl'">
          AVLTree.java
        </button>
        <button 
          :class="['tab-btn', { active: activeTab === 'lfu' }]" 
          @click="activeTab = 'lfu'">
          LFUCache.java
        </button>
        <button 
          :class="['tab-btn', { active: activeTab === 'tarjan' }]" 
          @click="activeTab = 'tarjan'">
          TarjanBridges.java
        </button>
      </div>
      <div class="badge-tag">
        {{ snippets[activeTab].badge }}
      </div>
    </div>
    <div class="code-viewport">
      <pre><code>{{ snippets[activeTab].code }}</code></pre>
    </div>
  </div>
</template>

<style scoped>
.code-showcase-container {
  max-width: 860px;
  margin: 32px auto 0 auto;
  border: 1px solid var(--vp-c-divider);
  background: var(--vp-c-bg-alt);
  border-radius: 10px;
  overflow: hidden;
  box-shadow: 0 10px 30px -10px rgba(0, 0, 0, 0.25);
  font-family: var(--vp-font-family-mono);
}

.showcase-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 10px 16px;
  background: var(--vp-c-bg-soft);
  border-bottom: 1px solid var(--vp-c-divider);
}

.traffic-lights {
  display: flex;
  gap: 6px;
}

.light {
  width: 10px;
  height: 10px;
  border-radius: 50%;
  display: inline-block;
}
.light.red { background: #ef4444; opacity: 0.8; }
.light.yellow { background: #f59e0b; opacity: 0.8; }
.light.green { background: #10b981; opacity: 0.8; }

.tab-list {
  display: flex;
  gap: 4px;
}

.tab-btn {
  background: transparent;
  border: 1px solid transparent;
  padding: 4px 10px;
  font-size: 0.8rem;
  color: var(--vp-c-text-2);
  border-radius: 4px;
  cursor: pointer;
  transition: all 0.2s ease;
  font-family: var(--vp-font-family-mono);
}

.tab-btn:hover {
  color: var(--vp-c-text-1);
}

.tab-btn.active {
  background: var(--vp-c-bg);
  color: var(--vp-c-brand-1);
  border-color: var(--vp-c-divider);
  font-weight: 600;
}

.badge-tag {
  font-size: 0.72rem;
  color: var(--vp-c-brand-1);
  background: var(--vp-c-brand-soft);
  padding: 3px 8px;
  border-radius: 4px;
  font-weight: 500;
}

.code-viewport {
  padding: 16px 20px;
  background: var(--vp-c-bg);
  overflow-x: auto;
  font-size: 0.85rem;
  line-height: 1.6;
}

.code-viewport pre {
  margin: 0;
  color: var(--vp-c-text-1);
}

@media (max-width: 640px) {
  .badge-tag {
    display: none;
  }
}
</style>

